package com.udemy.microservices.limitservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udemy.microservices.limitservice.bean.LimitConfigurationBean;
import com.udemy.microservices.limitservice.config.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LimitConfigurationController
 */
@RestController
@RequestMapping("/limit")
public class LimitConfigurationController {

  @Autowired
  private LimitConfiguration config;

  @GetMapping("/config")
  @HystrixCommand(fallbackMethod = "getConfigFallback")
  public LimitConfigurationBean getConfig() {
    //throw new RuntimeException("not available");
    return new LimitConfigurationBean(config.getMinimum(), config.getMaximum());
  }

  @GetMapping("/config/fallback")
  public LimitConfigurationBean getConfigFallback() {
    return new LimitConfigurationBean(9, 99);
  }

}
