package com.udemy.microservices.limitservice.controller;

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
  public LimitConfigurationBean getConfig() {
    return new LimitConfigurationBean(config.getMinimum(), config.getMaximum());
  }

}
