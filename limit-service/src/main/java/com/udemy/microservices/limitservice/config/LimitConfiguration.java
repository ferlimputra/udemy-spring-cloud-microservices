package com.udemy.microservices.limitservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * LimitConfiguration
 */
@Configuration
@ConfigurationProperties("limit-service")
public class LimitConfiguration {

  private int minimum;
  private int maximum;

  public LimitConfiguration() {
    super();
  }

  public LimitConfiguration(int minimum, int maximum) {
    super();
    this.minimum = minimum;
    this.maximum = maximum;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }

  public int getMaximum() {
    return maximum;
  }

  public void setMaximum(int maximum) {
    this.maximum = maximum;
  }

  @Override
  public String toString() {
    return "LimitConfiguration [maximum=" + maximum + ", minimum=" + minimum + "]";
  }

}
