package com.scraper.model.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class WebsiteResponseList implements Response {

  private HttpStatus status;
  private String message;
  private List<PlainWebsiteResponse> plainWebsiteResponses;

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

  public List<PlainWebsiteResponse> getPlainWebsiteResponses() {
    return plainWebsiteResponses;
  }

  public void setPlainWebsiteResponses(final List<PlainWebsiteResponse> plainWebsiteResponses) {
    this.plainWebsiteResponses = plainWebsiteResponses;
  }
}
