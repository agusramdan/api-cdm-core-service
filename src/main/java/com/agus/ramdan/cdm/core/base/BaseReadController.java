package com.agus.ramdan.cdm.core.base;

import com.agus.ramdan.cdm.core.exception.Errors;
import com.agus.ramdan.cdm.core.exception.ResourceNotFoundException;
import com.agus.ramdan.cdm.core.utils.BaseSpecifications;
import com.agus.ramdan.cdm.core.utils.BaseSpecificationsBuilder;
import com.agus.ramdan.cdm.core.utils.ChekUtils;
import com.agus.ramdan.cdm.core.utils.OffsetBasedPageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseReadController<T, ID> extends BaseController<T, ID> {

    @GetMapping("")
    @Operation(summary = "Get All")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema()))),
            @ApiResponse(responseCode = "204", description = "No Content",
                    content = @Content(schema = @Schema(implementation = Errors.class))),
            @ApiResponse(responseCode = "400", description = "Invalid tag value",
                    content = @Content(schema = @Schema(implementation = Errors.class)))})
    default ResponseEntity<List<T>> getAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "25") int limit,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "ids", required = false) String ids
    ) {
        val builder = new BaseSpecificationsBuilder<T>();
        if (StringUtils.hasText(ids)) {
            val list = Arrays.stream(ids.split(","))
                    .map(String::trim) // Menghapus spasi di sekitar angka
                    .map(Long::parseLong) // Mengonversi ke Long
                    .collect(Collectors.toList());
            builder.ids_in(list);
            if (!list.isEmpty()) {
                limit = Math.max(list.size(), limit);
            }
        }
        builder.withSearch(search);
        val spec = builder.build(BaseSpecifications::new);
        val pageable = new OffsetBasedPageRequest(offset, limit);
        val page = getRepository().findAll(spec, pageable);
        ChekUtils.ifEmptyThrow(page);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))

    })
    default ResponseEntity<T> getById(@PathVariable("id") ID id)
            throws ResourceNotFoundException {
        var data = ChekUtils.getOrThrow(getRepository().findById(id), () -> "Data not found for this id :: " + id);
        return ResponseEntity.ok().body(data);
    }
}
