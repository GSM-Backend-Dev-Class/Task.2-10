package com.gsm._8th.class4.backend.task210.domain.news.service.impl;

import com.gsm._8th.class4.backend.task210.domain.news.dto.News;
import com.gsm._8th.class4.backend.task210.domain.news.entity.NewsJpaEntity;
import com.gsm._8th.class4.backend.task210.domain.news.exception.NewsNotFoundException;
import com.gsm._8th.class4.backend.task210.domain.news.repository.NewsJpaRepository;
import com.gsm._8th.class4.backend.task210.domain.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsJpaRepository newsJpaRepository;

    @Override
    public News getNews(Long newsId) {
        return newsJpaRepository.findById(newsId).orElseThrow(NewsNotFoundException::new).toDomain();
    }

    @Override
    public List<News> getNews() {
        return newsJpaRepository.findAll().stream()
                .map(NewsJpaEntity::toDomain)
                .toList();
    }

    @Override
    public List<News> getNews(String keyword) {
        return newsJpaRepository.findByKeyword(keyword).stream()
                .map(NewsJpaEntity::toDomain)
                .toList();
    }

    @Override
    public News createNews(String title, String content) {
        return newsJpaRepository.save(NewsJpaEntity.builder()
                .title(title)
                .content(content)
                .build()
        ).toDomain();
    }

    @Override
    public News updateNews(Long newsId, String title, String content) {
        NewsJpaEntity news = newsJpaRepository.findById(newsId).orElseThrow(NewsNotFoundException::new);
        return newsJpaRepository.save(
                NewsJpaEntity.builder()
                        .newsId(news.getNewsId())
                        .title(title)
                        .content(content)
                        .build()
        ).toDomain();
    }

    @Override
    public void deleteNews(Long newsId) {
        newsJpaRepository.deleteById(newsId);
    }
}