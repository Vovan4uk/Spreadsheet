package com.mev.perepeliuk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);
    public static final String CHECK_API_STRING = "API works!";

    @RequestMapping("/api/")
    public String api() {
        return CHECK_API_STRING;
    }
}
