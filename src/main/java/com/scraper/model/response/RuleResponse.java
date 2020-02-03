package com.scraper.model.response;

import org.springframework.http.HttpStatus;

public class RuleResponse extends PlainRuleResponse implements Response {

  private HttpStatus status;
  private String message;

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
