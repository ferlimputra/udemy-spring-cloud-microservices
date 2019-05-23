package com.udemy.microservices.gatewayserver.filter;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * LoggingService
 */
@Component
public class LoggingFilter extends ZuulFilter {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public Object run() throws ZuulException {
    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    logger.info("Request -> {} Request URI -> {}", request, request.getRequestURI());
    return null;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public int filterOrder() {
    return FilterConstants.DEBUG_FILTER_ORDER;
  }

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }


}
