package com.scraper.repository;

import com.scraper.model.domain.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebsiteRepository extends JpaRepository<Website, Long> {
  List<Website> findAll();
}