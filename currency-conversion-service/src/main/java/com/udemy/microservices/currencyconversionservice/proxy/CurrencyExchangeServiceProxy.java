package com.udemy.microservices.currencyconversionservice.proxy;

import com.udemy.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * CurrencyExchangeServiceProxy
 */
@RibbonClient(name = "currency-exchange-service")
@FeignClient(name = "gateway-server", path = "currency-exchange-service/currency-exchange")
public interface CurrencyExchangeServiceProxy {

  @GetMapping("/source/{source}/target/{target}")
  public CurrencyConversionBean getExchangeValue(@PathVariable("source") String source,
      @PathVariable("target") String target);

}
