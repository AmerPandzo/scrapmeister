package com.scraper.model.request;

import java.util.List;

/**
 * Website request class.
 */
public class WebsiteRequest {

  private String url;
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

  @Override
  public String toString() {
    return "WebsiteRequest{" +
        "url='" + url + '\'' +
        ", rules=" + rules +
        '}';
  }
}
