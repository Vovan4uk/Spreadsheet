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

import java.util.List;

@RestController
@RequestMapping(value = "/api/spreadsheet")
public class SpreadsheetController {

    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetController.class);

    @Autowired
    private SpreadsheetService spreadsheetService;
    @Autowired
    private SpreadsheetUtils spreadsheetUtils;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spreadsheet>> findAllSpreadsheet() {
        List<Spreadsheet> spreadsheets = spreadsheetService.getAllSpreasheetWithoutCells();
        return new ResponseEntity<>(spreadsheets, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpreadsheetCell[][]> findSpreadsheetData(@PathVariable Long id) {
        Spreadsheet spreadsheet = spreadsheetService.getById(id);
        return new ResponseEntity<>(spreadsheetUtils.prepareSpreadsheetData(spreadsheet), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spreadsheet>> createSpreadsheet(@RequestBody Spreadsheet spreadsheet) {
        spreadsheetService.save(spreadsheet);
        List<Spreadsheet> spreadsheets = spreadsheetService.getAllSpreasheetWithoutCells();
        return new ResponseEntity<>(spreadsheets, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spreadsheet>> deleteSpreadsheet(@PathVariable Long id) {
        spreadsheetService.removeById(id);
        List<Spreadsheet> spreadsheets = spreadsheetService.getAllSpreasheetWithoutCells();
        return new ResponseEntity<>(spreadsheets, HttpStatus.OK);
    }
}
