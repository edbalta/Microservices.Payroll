package com.BilgeAdam.Microservices.Payroll.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SsiDeclaration", url = "http://localhost:8081")
public interface SsiDeclarationClient {
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String getTest();
}
