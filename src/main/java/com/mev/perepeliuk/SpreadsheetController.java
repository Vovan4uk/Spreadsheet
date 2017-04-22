package com.mev.perepeliuk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpreadsheetController {

    @RequestMapping("/api/")
    public String api() {
        return "test api";
    }

}
