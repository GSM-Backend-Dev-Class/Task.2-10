package com.gsm._8th.class4.backend.task210.domain.news.service.impl;

import com.gsm._8th.class4.backend.task210.domain.news.dto.News;
import com.gsm._8th.class4.backend.task210.domain.news.entity.NewsJpaEntity;
import com.gsm._8th.class4.backend.task210.domain.news.exception.NewsNotFoundException;
import com.gsm._8th.class4.backend.task210.domain.news.repository.NewsRepository;
import com.gsm._8th.class4.backend.task210.domain.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public News getNews(Long newsId) {
        return newsRepository.findById(newsId).orElseThrow(NewsNotFoundException::new).toDomain();
    }

    @Override
    public List<News> getNews() {
        return newsRepository.findAll().stream()
                .map(NewsJpaEntity::toDomain)
                .toList();
    }

    @Override
    public News createNews(String title, String content) {
        return newsRepository.save(NewsJpaEntity.builder()
                .title(title)
                .content(content)
                .build()
        ).toDomain();
    }

    @Override
    public News updateNews(Long newsId, String title, String content) {
        NewsJpaEntity news = newsRepository.findById(newsId).orElseThrow(NewsNotFoundException::new);
        return newsRepository.save(
                NewsJpaEntity.builder()
                        .newsId(news.getNewsId())
                        .title(title)
                        .content(content)
                        .build()
        ).toDomain();
    }

    @Override
    public void deleteNews(Long newsId) {
        newsRepository.deleteById(newsId);
    }
}