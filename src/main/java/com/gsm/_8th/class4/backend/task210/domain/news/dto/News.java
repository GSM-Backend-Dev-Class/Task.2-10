package com.gsm._8th.class4.backend.task210.domain.news.dto;

import com.gsm._8th.class4.backend.task210.domain.news.entity.NewsJpaEntity;

public record News(Long newsId, String newsTitle, String newsContent) {
    public NewsJpaEntity toJpaEntity() {
        return NewsJpaEntity.builder()
                .newsId(newsId)
                .title(newsTitle)
                .content(newsContent)
                .build();
    }
}