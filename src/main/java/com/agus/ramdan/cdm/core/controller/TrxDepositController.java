package com.agus.ramdan.cdm.core.controller;

import com.agus.ramdan.cdm.core.base.BaseReadController;
import com.agus.ramdan.cdm.core.domain.TrxDeposit;
import com.agus.ramdan.cdm.core.dto.TrxDepositMapper;
import com.agus.ramdan.cdm.core.exception.ResourceNotFoundException;
import com.agus.ramdan.cdm.core.repository.TrxDepositRepository;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cdm/core/deposit")
@RequiredArgsConstructor
@Log4j2
public class TrxDepositController implements BaseReadController<TrxDeposit, UUID> {

    @Getter
    private final TrxDepositRepository repository;
    private final TrxDepositMapper mapper;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TrxDeposit.class)))),
    })
    @Override
    public ResponseEntity<List<TrxDeposit>> getAll(int offset, int limit, String search, String ids) {
        return BaseReadController.super.getAll(offset, limit, search, ids);
    }

    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDeposit.class)),})
    })
    @Override
    public ResponseEntity<TrxDeposit> getById(UUID aLong) throws ResourceNotFoundException {
        return BaseReadController.super.getById(aLong);
    }
}
