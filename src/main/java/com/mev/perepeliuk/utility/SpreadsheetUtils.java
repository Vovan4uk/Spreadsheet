package com.mev.perepeliuk.utility;

import com.mev.perepeliuk.domain.Spreadsheet;
import com.mev.perepeliuk.domain.SpreadsheetCell;
import org.springframework.stereotype.Component;

@Component
public class SpreadsheetUtils {
    public SpreadsheetCell[][] prepareSpreadsheetData(Spreadsheet spreadsheet){
        SpreadsheetCell[][] spreadsheetData = new SpreadsheetCell[10][10];
        for (SpreadsheetCell spreadsheetCell : spreadsheet.getSpreadsheetCells()){
            spreadsheetData[spreadsheetCell.getRow()][spreadsheetCell.getCol()] = spreadsheetCell;
        }
        return spreadsheetData;
    }
}
