package com.gsm._8th.class4.backend.task210.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NEWS_NOT_FOUND("News not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;
}