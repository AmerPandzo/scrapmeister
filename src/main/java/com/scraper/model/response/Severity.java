package com.scraper.model.response;

import java.io.Serializable;

/**
 * This enum contains the possible error severity types.
 */
public enum Severity implements Serializable {
  INFO,
  SUCCESS,
  WARNING,
  ERROR
}
