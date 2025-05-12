package com.gsm._8th.class4.backend.task210.global.error.handler;

import com.gsm._8th.class4.backend.task210.global.error.dto.Error;
import com.gsm._8th.class4.backend.task210.global.error.exception.GlobalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Error> handleGlobalException(GlobalException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(new Error(
                e.getErrorCode().getMessage(),
                e.getErrorCode().getHttpStatus().value()
        ));
    }
}