package com.mev.perepeliuk.controller;

import com.mev.perepeliuk.domain.FunctionCategory;
import com.mev.perepeliuk.service.FunctionCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/function_category")
public class FunctionCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(FunctionCategoryController.class);

    @Autowired
    private FunctionCategoryService functionCategoryService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FunctionCategory>> findAllFunctionCategory() {
        List<FunctionCategory> functionCategories = functionCategoryService.getAll();
        return new ResponseEntity<>(functionCategories, HttpStatus.OK);
    }
}
