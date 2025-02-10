package com.agus.ramdan.cdm.core.dto.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTrxDepositDenominationDTO {
    private BigDecimal denomination;
    private Integer quantity;
    private BigDecimal amount;
    private String type;
}

