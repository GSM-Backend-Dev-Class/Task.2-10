package com.gsm._8th.class4.backend.task210.domain.news.service;

import com.gsm._8th.class4.backend.task210.domain.news.dto.News;

import java.util.List;

public interface NewsService {
    News getNews(Long newsId);

    List<News> getNews();

    List<News> getNews(String keyword);

    News createNews(String title, String content);

    News updateNews(Long newsId, String title, String content);

    void deleteNews(Long newsId);
}