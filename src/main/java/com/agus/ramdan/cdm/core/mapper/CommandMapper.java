package com.agus.ramdan.cdm.core.mapper;

import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import com.agus.ramdan.cdm.core.domain.TrxDepositDenomination;
import com.agus.ramdan.cdm.core.dto.command.CreateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.dto.command.CreateTrxDepositDenominationDTO;
import com.agus.ramdan.cdm.core.dto.command.TrxDepositDenominationResponseDTO;
import com.agus.ramdan.cdm.core.dto.command.TrxDepositResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandMapper {
    TrxDeposit toEntity(CreateTrxDepositCommandDTO dto);
    TrxDepositDenomination toEntity(CreateTrxDepositDenominationDTO dto);
    TrxDepositResponseDTO toResponseDto(TrxDeposit entity);
    TrxDepositDenominationResponseDTO toResponseDto(TrxDepositDenomination entity);
}

