package com.agus.ramdan.cdm.core.dto.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrxDepositDenominationQueryDTO {
    private UUID id;
    private BigDecimal denomination;
    private Integer quantity;
    private BigDecimal amount;
    private String type;
}
