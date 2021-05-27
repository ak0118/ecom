package com.ecom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ping")
public class PingController {
    @RequestMapping("")
    public String ping() {
        return "Shopping Cart Pinging";
    }

}
