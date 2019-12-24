package com.scraper.repository;

import com.scraper.domain.EntryParseRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryParseRuleRepository extends JpaRepository<EntryParseRule, Long> {
}

