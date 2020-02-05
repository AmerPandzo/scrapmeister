package com.scraper.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * This object represents the error object.
 */
public class ErrorResponse implements Response {

  private static final long serialVersionUID = 8575147134358945802L;

  private String source;
  private List<Message> messages;

  public ErrorResponse(final String source) {
    this.source = source;
  }

  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  public void setSource(final String source) {
    this.source = source;
  }

  @JsonProperty("messages")
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(final List<Message> messages) {
    this.messages = messages;
  }

  public void addMessage(final Message message) {
    if (messages == null) {
      messages = new ArrayList<>();
    }
    messages.add(message);
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    final ErrorResponse that = (ErrorResponse) object;

    return new EqualsBuilder()
        .append(source, that.source)
        .append(messages, that.messages)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(source)
        .append(messages)
        .toHashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("class ErrorResponse {\n");
    builder.append("  source: ").append(source).append("\n");
    builder.append("  messages: ").append(messages).append("\n");
    builder.append("}\n");
    return builder.toString();
  }
}
