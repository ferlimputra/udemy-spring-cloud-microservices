package com.udemy.microservices.currencyexchangeservice.controller;

import com.udemy.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.udemy.microservices.currencyexchangeservice.dao.ExchangeValueDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CurrencyExchangeController
 */
@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeValueDao exchangeValueDao;

  @GetMapping(value = "/source/{source}/target/{target}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ExchangeValue getExchangeValue(@PathVariable("source") String source,
      @PathVariable("target") String target) {
    ExchangeValue exchangeValue = exchangeValueDao.findBySourceAndTarget(source, target);
    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    logger.info("{}", exchangeValue);
    return exchangeValue;
  }

}
