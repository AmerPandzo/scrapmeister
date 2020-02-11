package com.scraper.model.response;

import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;

import java.time.LocalDateTime;
import java.util.Set;

public class PlainWebsiteResponse {

  private String title;
  private String url;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Website parent;
  private Set<Website> children;
  private Set<Rule> rules;

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt(final LocalDateTime updatedAt) {
    return this.updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Website getParent() {
    return parent;
  }

  public void setParent(final Website parent) {
    this.parent = parent;
  }

  public Set<Website> getChildren() {
    return children;
  }

  public void setChildren(final Set<Website> children) {
    this.children = children;
  }

  public Set<Rule> getRules() {
    return rules;
  }

  public void setRules(final Set<Rule> rules) {
    this.rules = rules;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
