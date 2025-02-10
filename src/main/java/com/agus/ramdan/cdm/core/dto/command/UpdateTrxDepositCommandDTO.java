package com.agus.ramdan.cdm.core.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTrxDepositCommandDTO {
    private UUID id;
    private String status;
}

