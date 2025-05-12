package com.gsm._8th.class4.backend.task210.domain.news.controller;

import com.gsm._8th.class4.backend.task210.domain.news.dto.CommandNewsRequest;
import com.gsm._8th.class4.backend.task210.domain.news.dto.News;
import com.gsm._8th.class4.backend.task210.domain.news.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/{newsId}")
    public ResponseEntity<News> getNews(@PathVariable(value = "newsId") Long newsId) {
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getNews(newsId));
    }

    @GetMapping
    public ResponseEntity<List<News>> getNewsList() {
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getNews());
    }

    @PostMapping
    public ResponseEntity<News> createNews(@Valid @RequestBody CommandNewsRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.createNews(request.title(), request.content()));
    }

    @PutMapping("/{newsId}")
    public ResponseEntity<News> updateNews(
            @PathVariable(value = "newsId") Long newsId,
            @Valid @RequestBody CommandNewsRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(newsService.updateNews(newsId, request.title(), request.content()));
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<Void> deleteNews(@PathVariable(value = "newsId") Long newsId) {
        newsService.deleteNews(newsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}