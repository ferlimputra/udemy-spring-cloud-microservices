package com.udemy.microservices.limitservice.bean;

/**
 * LimitConfigurationBean
 */
public class LimitConfigurationBean {

  private int minimum;
  private int maximum;

  public LimitConfigurationBean() {
    super();
  }

  public LimitConfigurationBean(int minimum, int maximum) {
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
    return "LimitConfigurationBean [maximum=" + maximum + ", minimum=" + minimum + "]";
  }

}
