package com.scraper.repository;

import com.scraper.domain.TargetWebsite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TargetWebsiteRepository extends JpaRepository<TargetWebsite, Long> {
  List<TargetWebsite> findAll();
}