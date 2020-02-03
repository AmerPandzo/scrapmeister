package com.scraper.model.request;

import com.sun.istack.Nullable;

import java.util.List;

/**
 * Website request class.
 */
public class WebsiteRequest {

  private String url;
  private Long parentId;
  private List<RuleRequest> rules;

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public List<RuleRequest> getRules() {
    return rules;
  }

  public void setRules(final List<RuleRequest> rules) {
    this.rules = rules;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(final Long parentId) {
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "WebsiteRequest{" +
        "url='" + url + '\'' +
        ", parentId=" + parentId +
        ", rules=" + rules +
        '}';
  }
}
