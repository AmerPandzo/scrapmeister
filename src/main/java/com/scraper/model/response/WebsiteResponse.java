package com.scraper.model.response;

import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class WebsiteResponse implements Response {
  private HttpStatus status;
  private String message;
  private String url;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Website parent;
  private List<Website> children;
  private List<Rule> rules;

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

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
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

  public List<Website> getChildren() {
    return children;
  }

  public void setChildren(final List<Website> children) {
    this.children = children;
  }

  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(final List<Rule> rules) {
    this.rules = rules;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(final HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "WebsiteResponse{" +
        "status=" + status +
        ", message='" + message + '\'' +
        '}';
  }
}
