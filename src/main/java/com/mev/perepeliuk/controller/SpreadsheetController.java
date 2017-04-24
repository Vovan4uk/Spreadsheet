package com.mev.perepeliuk.controller;

import com.mev.perepeliuk.domain.Function;
import com.mev.perepeliuk.domain.FunctionCategory;
import com.mev.perepeliuk.domain.Spreadsheet;
import com.mev.perepeliuk.domain.SpreadsheetCell;
import com.mev.perepeliuk.service.FunctionCategoryService;
import com.mev.perepeliuk.service.FunctionService;
import com.mev.perepeliuk.service.SpreadsheetCellService;
import com.mev.perepeliuk.service.SpreadsheetService;
import com.mev.perepeliuk.utility.SpreadsheetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    private FunctionService functionService;
    @Autowired
    private FunctionCategoryService functionCategoryService;
    @Autowired
    private SpreadsheetService spreadsheetService;
    @Autowired
    private SpreadsheetCellService spreadsheetCellService;
    @Autowired
    private SpreadsheetUtils spreadsheetUtils;

    @RequestMapping("/api/")
    public String api() {
        return "API works!";
    }

    @RequestMapping(value = "/api/function_categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FunctionCategory>> findAllFunctionCategory(HttpServletRequest req) {
        List<FunctionCategory> functionCategories = functionCategoryService.getAll();
        return new ResponseEntity<>(functionCategories, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/function_category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@RequestBody FunctionCategory functionCategory) {
        functionCategoryService.save(functionCategory);
    }

    @RequestMapping(value = "/api/functions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Function>> findAllFunction(HttpServletRequest req) {
        List<Function> functions = functionService.getAll();
        return new ResponseEntity<>(functions, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/spreadsheets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spreadsheet>> findAllSpreadsheet(HttpServletRequest req) {
        List<Spreadsheet> spreadsheets = spreadsheetService.getAllSpreasheetWithoutCells();
        return new ResponseEntity<>(spreadsheets, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/spreadsheet/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spreadsheet> findSpreadsheet(@PathVariable Long id, HttpServletRequest req) {
        Spreadsheet spreadsheet = spreadsheetService.getById(id);
        return new ResponseEntity<>(spreadsheet, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/spreadsheet_data/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpreadsheetCell[][]> findSpreadsheetData(@PathVariable Long id, HttpServletRequest req) {
        Spreadsheet spreadsheet = spreadsheetService.getById(id);
        return new ResponseEntity<>(spreadsheetUtils.prepareSpreadsheetData(spreadsheet), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/spreadsheets", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spreadsheet>> createSpreadsheet(@RequestBody Spreadsheet spreadsheet, HttpServletRequest req) {
        spreadsheetService.save(spreadsheet);
        List<Spreadsheet> spreadsheets = spreadsheetService.getAllSpreasheetWithoutCells();
        return new ResponseEntity<>(spreadsheets, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/spreadsheet/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spreadsheet>> deleteSpreadsheet(@PathVariable Long id, HttpServletRequest req) {
        spreadsheetService.removeById(id);
        List<Spreadsheet> spreadsheets = spreadsheetService.getAllSpreasheetWithoutCells();
        return new ResponseEntity<>(spreadsheets, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/spreadsheet_cell", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSpreadsheetCell(@RequestBody SpreadsheetCell spreadsheetCell, HttpServletRequest req) {
        spreadsheetCellService.update(spreadsheetCell);
    }

    @RequestMapping(value = "/api/spreadsheet_cell", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addSpreadsheetCell(@RequestBody SpreadsheetCell spreadsheetCell, HttpServletRequest req) {
        spreadsheetCellService.save(spreadsheetCell);
    }
}
