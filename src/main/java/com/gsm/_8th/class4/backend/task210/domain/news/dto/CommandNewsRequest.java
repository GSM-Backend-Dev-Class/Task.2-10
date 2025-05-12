package com.gsm._8th.class4.backend.task210.domain.news.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommandNewsRequest(@NotNull @Size(max = 100) String title, @NotNull @Size(max = 2500) String content) {
}