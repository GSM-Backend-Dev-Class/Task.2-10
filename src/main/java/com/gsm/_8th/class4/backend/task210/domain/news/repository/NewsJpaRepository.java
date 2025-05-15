package com.gsm._8th.class4.backend.task210.domain.news.repository;

import com.gsm._8th.class4.backend.task210.domain.news.entity.NewsJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsJpaRepository extends JpaRepository<NewsJpaEntity, Long> {
}