package com.gsm._8th.class4.backend.task210.domain.news.entity;

import com.gsm._8th.class4.backend.task210.domain.news.dto.News;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NewsJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long newsId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public News toDomain() {
        return new News(newsId, title, content);
    }
}