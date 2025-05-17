package com.gsm._8th.class4.backend.task210.domain.news.repository;

import com.gsm._8th.class4.backend.task210.domain.news.entity.NewsJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsJpaRepository extends JpaRepository<NewsJpaEntity, Long> {
    @Query("SELECT n FROM NewsJpaEntity n WHERE n.title LIKE %:keyword% OR n.content LIKE %:keyword%")
    List<NewsJpaEntity> findByKeyword(String keyword);
}