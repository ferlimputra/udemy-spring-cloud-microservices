package com.udemy.microservices.currencyexchangeservice.dao;

import java.util.UUID;
import com.udemy.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ExchangeRateDao
 */
@Repository
public interface ExchangeValueDao extends JpaRepository<ExchangeValue, UUID> {

  public ExchangeValue findBySourceAndTarget(String source, String target);

}
