package com.agus.ramdan.cdm.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorValidation {
    private final String message;
    private final String key;
    private final Object value;
}