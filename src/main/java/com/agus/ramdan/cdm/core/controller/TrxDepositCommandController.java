package com.agus.ramdan.cdm.core.controller;

import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import com.agus.ramdan.cdm.core.dto.command.CreateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.dto.command.UpdateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.service.TrxDepositCommandService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cdm/core/deposit/command")
@RequiredArgsConstructor
@Log4j2
public class TrxDepositCommandController {
    private final TrxDepositCommandService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTrxDepositCommandDTO dto) {
        service.createTrxDeposit(dto);
        return ResponseEntity.ok("Transaction created successfully");
    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDeposit.class)),})
    })
    public ResponseEntity<String> update(@RequestBody UpdateTrxDepositCommandDTO dto) {
        service.updateTrxDeposit(dto);
        return ResponseEntity.ok("Transaction updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.deleteTrxDeposit(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}
