package com.scraper.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * This class represents an error message.
 */
public class Message implements Serializable {

  private Severity severity;
  private String code;
  private MessageTitle title;
  private MessageDetail detail;

  public Message() {
  }

  public Message(final Severity severity, final String code, final MessageTitle title, final MessageDetail detail) {
    this.severity = severity;
    this.code = code;
    this.title = title;
    this.detail = detail;
  }

  @JsonProperty("severity")
  public Severity getSeverity() {
    return severity;
  }

  public void setSeverity(final Severity severity) {
    this.severity = severity;
  }

  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  @JsonProperty("title")
  public MessageTitle getTitle() {
    return title;
  }

  public void setTitle(final MessageTitle title) {
    this.title = title;
  }

  @JsonProperty("detail")
  public MessageDetail getDetail() {
    return detail;
  }

  public void setDetail(final MessageDetail detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    final Message message = (Message) object;

    return new EqualsBuilder()
        .append(severity, message.severity)
        .append(code, message.code)
        .append(title, message.title)
        .append(detail, message.detail)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(severity)
        .append(code)
        .append(title)
        .append(detail)
        .toHashCode();
  }

  @Override
  public String toString() {
    StringBuilder builderb = new StringBuilder();
    builderb.append("class Message {\n");
    builderb.append("  severity: ").append(severity).append("\n");
    builderb.append("  code: ").append(code).append("\n");
    builderb.append("  title: ").append(title).append("\n");
    builderb.append("  detail: ").append(detail).append("\n");
    builderb.append("}\n");
    return builderb.toString();
  }
}
