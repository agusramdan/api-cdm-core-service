package com.agus.ramdan.cdm.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositDenominationRequest implements Serializable {
    @NotNull(message = "type cannot be null.")
    @NotEmpty(message = "type cannot be empty.")
    @Pattern(regexp = "coin|note", message = "Invalid type. Only 'coin' or 'note' are allowed.")
    private String type;
    @NotNull(message = "denomination cannot be null.")
    @Positive(message = "denomination must be positive value.")
    private BigDecimal denomination;
    @NotNull(message = "quantity cannot be null.")
    @Positive(message = "quantity must be positive value.")
    private Integer quantity;
    @Positive(message = "denomination amount cannot be negative or zero value.")
    @NotNull(message = "denomination must be positive value.")
    private BigDecimal amount;
}
