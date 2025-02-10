package com.agus.ramdan.cdm.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositDto implements Serializable {
    private UUID id;
    private LocalDateTime created_on;
    private LocalDateTime updated_on;
    private String created_by;
    private String updated_by;
    private String token;
    private String signature;
    private String status;

    private String service_transaction_id;
    private String service_transaction_no;

    private String service_product_id;
    private String service_product_code;
    private String service_product_name;

    private String cdm_trx_no;

    private LocalDateTime cdm_trx_date;
    private LocalDateTime trx_date;

    private BigDecimal amount;
    private List<TrxDepositDenominationDto> denominations;

}
