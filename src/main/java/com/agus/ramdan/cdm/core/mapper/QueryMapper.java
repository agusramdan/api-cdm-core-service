package com.agus.ramdan.cdm.core.mapper;

import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import com.agus.ramdan.cdm.core.dto.query.TrxDepositQueryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QueryMapper {
    TrxDepositQueryDTO toDto(TrxDeposit entity);
    List<TrxDepositQueryDTO> toDtoList(List<TrxDeposit> entities);
}
