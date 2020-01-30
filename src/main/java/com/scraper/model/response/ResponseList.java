package com.scraper.model.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseList<R> implements Response {

  private HttpStatus status;
  private String message;
  private List<R> plainResponses;

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

  public List<R> getPlainResponses() {
    return plainResponses;
  }

  public void setPlainResponses(final List<R> plainResponses) {
    this.plainResponses = plainResponses;
  }
}
