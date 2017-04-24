package com.mev.perepeliuk.service;

import com.mev.perepeliuk.domain.Spreadsheet;

import java.util.List;

public interface SpreadsheetService extends GenericService<Spreadsheet>{
    List<Spreadsheet> getAllSpreasheetWithoutCells();
}
