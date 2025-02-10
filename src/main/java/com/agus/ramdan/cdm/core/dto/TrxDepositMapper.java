package com.agus.ramdan.cdm.core.dto;

import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import com.agus.ramdan.cdm.core.domain.TrxDepositDenomination;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrxDepositMapper {

    TrxDepositDenomination trxDepositMachineDenominationDtoToTrxDepositMachineDenomination(TrxDepositDenominationDto trxDepositMachineDenominationDto);

    TrxDepositDenominationDto trxDepositMachineDenominationToTrxDepositMachineDenominationDto(TrxDepositDenomination trxDepositMachineDenomination);

    TrxDepositDenomination trxDepositMachineDenominationRequestToTrxDepositMachineDenomination(TrxDepositDenominationRequest trxDepositMachineDenominationRequest);

    TrxDepositDenominationRequest toTrxDeposit(TrxDepositDenomination trxDepositMachineDenomination);

    TrxDeposit toTrxDeposit(TrxDepositRequest trxDepositMachineRequest);

    TrxDepositResponse toTrxDepositResponse(TrxDeposit trxDeposit);
}
