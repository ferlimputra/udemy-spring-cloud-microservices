package com.udemy.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import com.udemy.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.udemy.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CurrencyConversionController
 */
@RestController
@RequestMapping("convert")
public class CurrencyConversionController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

  @GetMapping("/source/{source}/target/{target}/amount/{amount}")
  public CurrencyConversionBean convertCurrency(@PathVariable("source") String source,
      @PathVariable("target") String target, @PathVariable("amount") BigDecimal amount) {
    /*
     * Web Client Method
     * 
     * WebClient exchangeWebClient = WebClient.create("http://localhost:8000");
     * Mono<CurrencyConversionBean> response = exchangeWebClient.get()
     * .uri("/currency-exchange/source/{source}/target/{target}", source, target).retrieve()
     * .bodyToMono(CurrencyConversionBean.class);
     * 
     * CurrencyConversionBean conversionBean = response.block();
     */

    /*
     * Rest Template Method
     * 
     * String getExchangeUrl =
     * "http://localhost:8000/currency-exchange/source/{source}/target/{target}";
     * ResponseEntity<CurrencyConversionBean> response = new RestTemplate()
     * .getForEntity(getExchangeUrl, CurrencyConversionBean.class, source, target);
     * 
     * CurrencyConversionBean conversionBean = response.getBody();
     */

    // Feign
    CurrencyConversionBean conversionBean =
        currencyExchangeServiceProxy.getExchangeValue(source, target);
    conversionBean.setAmount(amount);
    conversionBean.setConvertedAmount(amount.multiply(conversionBean.getConversionFactor()));

    logger.info("{}", conversionBean);
    return conversionBean;
  }

}
