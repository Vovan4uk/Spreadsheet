package com.mev.perepeliuk.controller;

import com.mev.perepeliuk.domain.Function;
import com.mev.perepeliuk.service.FunctionService;
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
@RequestMapping(value = "/api/function")
public class FunctionController {

    private static final Logger logger = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    private FunctionService functionService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Function>> findAllFunction() {
        List<Function> functions = functionService.getAll();
        return new ResponseEntity<>(functions, HttpStatus.OK);
    }
}
