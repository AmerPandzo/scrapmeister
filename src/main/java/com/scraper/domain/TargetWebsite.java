package com.scraper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * TargetWebsite class.
 */
@Entity
public class TargetWebsite {

  @Id
  @GeneratedValue
  private Long id;
  private String url;

  @OneToOne
  private EntryParseRule entryParseRule;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public EntryParseRule getEntryParseRule() {
    return entryParseRule;
  }

  public void setEntryParseRule(EntryParseRule entryParseRule) {
    this.entryParseRule = entryParseRule;
  }
}