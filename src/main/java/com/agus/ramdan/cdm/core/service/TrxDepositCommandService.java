package com.agus.ramdan.cdm.core.service;

import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import com.agus.ramdan.cdm.core.dto.command.CreateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.dto.command.TrxDepositResponseDTO;
import com.agus.ramdan.cdm.core.dto.command.UpdateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.mapper.CommandMapper;
import com.agus.ramdan.cdm.core.repository.TrxDepositRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class TrxDepositCommandService {
    private final TrxDepositRepository repository;
    private final CommandMapper commandMapper;

    public TrxDepositResponseDTO createTrxDeposit(CreateTrxDepositCommandDTO dto) {
        val option_trx = repository.findByTokenAndSignature(dto.getToken(), dto.getSignature());
        if (option_trx.isPresent()){
            log.info("Resend detected Token and Signature");
        }
        return option_trx.or(() -> {
            TrxDeposit trxDeposit = commandMapper.toEntity(dto);
            return Optional.of(repository.save(trxDeposit));
        }).map(commandMapper::toResponseDto).orElse(null);
    }

    public TrxDepositResponseDTO updateTrxDeposit(UpdateTrxDepositCommandDTO dto) {
        TrxDeposit trxDeposit = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        trxDeposit.setStatus(dto.getStatus());
        return commandMapper.toResponseDto(repository.save(trxDeposit));
    }

    public void deleteTrxDeposit(UUID id) {
        repository.deleteById(id);
    }
}

