package com.agus.ramdan.cdm.core.service;

import com.agus.ramdan.cdm.core.dto.query.TrxDepositQueryDTO;
import com.agus.ramdan.cdm.core.mapper.QueryMapper;
import com.agus.ramdan.cdm.core.repository.TrxDepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrxDepositQueryService {
    private final TrxDepositRepository repository;
    private final QueryMapper queryMapper;

    public List<TrxDepositQueryDTO> getAllTrxDeposits() {
        return queryMapper.toDtoList(repository.findAll());
    }

    public TrxDepositQueryDTO getTrxDepositById(UUID id) {
        return repository.findById(id)
                .map(queryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}

