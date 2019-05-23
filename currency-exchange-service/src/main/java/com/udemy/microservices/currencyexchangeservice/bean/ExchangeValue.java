package com.udemy.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * ExchangeValue
 */
@Entity
public class ExchangeValue {

  @Id
  @GeneratedValue
  private UUID id;

  private String source;
  private String target;
  private BigDecimal conversionFactor;
  private int port;

  public ExchangeValue() {
    super();
  }

  public ExchangeValue(String source, String target, BigDecimal conversionFactor) {
    super();
    this.source = source;
    this.target = target;
    this.conversionFactor = conversionFactor;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public BigDecimal getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(BigDecimal conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}
