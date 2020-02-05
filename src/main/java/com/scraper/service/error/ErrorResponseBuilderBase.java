package com.scraper.service.error;

import com.scraper.model.response.ErrorResponse;

/**
 * This class mimics the builder pattern, and encapsulates the complexity
 * involved in creating a new ErrorResponse object.
 */
public class ErrorResponseBuilderBase {

  public ErrorResponse build(final String source) {
    return new ErrorResponse(source);
  }
}
