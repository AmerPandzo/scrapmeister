package com.scraper.model.request;

import java.util.List;

/**
 * Rule request class.
 */
public class RuleRequest {
  private Long id;
  private String newsContainer;
  private String title;
  private String content;
  private String link;
  private List<WebsiteRequest> websites;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getNewsContainer() {
    return newsContainer;
  }

  public void setNewsContainer(final String newsContainer) {
    this.newsContainer = newsContainer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(final String content) {
    this.content = content;
  }

  public String getLink() {
    return link;
  }

  public void setLink(final String link) {
    this.link = link;
  }

  public List<WebsiteRequest> getWebsites() {
    return websites;
  }

  public void setWebsites(final List<WebsiteRequest> websites) {
    this.websites = websites;
  }
}
