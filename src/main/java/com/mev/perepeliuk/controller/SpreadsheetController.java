package com.mev.perepeliuk.controller;

import com.mev.perepeliuk.domain.FunctionCategory;
import com.mev.perepeliuk.service.FunctionCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SpreadsheetController {

    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetController.class);

    @Autowired
    private FunctionCategoryService functionCategoryService;

    @RequestMapping("/api/")
    public String api() {
        return "test api";
    }

    @RequestMapping(value = "/api/function_category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FunctionCategory>> findAllPerson(HttpServletRequest req) {
        List<FunctionCategory> functionCategories = functionCategoryService.getAll();
        return new ResponseEntity<>(functionCategories, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/function_category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@RequestBody FunctionCategory functionCategory) {
        functionCategoryService.save(functionCategory);
    }
}
