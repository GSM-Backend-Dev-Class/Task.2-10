package com.gsm._8th.class4.backend.task210.domain.news.exception;

import com.gsm._8th.class4.backend.task210.global.error.ErrorCode;
import com.gsm._8th.class4.backend.task210.global.error.exception.GlobalException;

public class NewsNotFoundException extends GlobalException {
    public NewsNotFoundException() {
        super(ErrorCode.NEWS_NOT_FOUND);
    }
}