package com.mev.perepeliuk.controller;

import com.mev.perepeliuk.domain.SpreadsheetCell;
import com.mev.perepeliuk.service.SpreadsheetCellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/spreadsheet_cell")
public class SpreadsheetCellController {

    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetCellController.class);

    @Autowired
    private SpreadsheetCellService spreadsheetCellService;

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSpreadsheetCell(@RequestBody SpreadsheetCell spreadsheetCell) {
        spreadsheetCellService.update(spreadsheetCell);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addSpreadsheetCell(@RequestBody SpreadsheetCell spreadsheetCell) {
        spreadsheetCellService.save(spreadsheetCell);
    }
}
