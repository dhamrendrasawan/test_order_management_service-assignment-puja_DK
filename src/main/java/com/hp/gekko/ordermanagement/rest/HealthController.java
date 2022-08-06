package com.hp.gekko.ordermanagement.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.gekko.ordermanagement.entity.Health;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/order-controller")
public class HealthController {

    public HealthController() {}

    @RequestMapping(method=GET, value="/health")
    public Health getPing() {
        return new Health("service-quickstart", "healthy");
    }

    @RequestMapping(method=GET, value="/service-quickstart/health")
    public Health getHealth() {
        return new Health("test-order-management", "healthy");
    }
}
