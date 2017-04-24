package com.mev.perepeliuk.service;

import com.mev.perepeliuk.dao.FunctionDao;
import com.mev.perepeliuk.dao.SpreadsheetDao;
import com.mev.perepeliuk.domain.Function;
import com.mev.perepeliuk.domain.Spreadsheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpreadsheetServiceImpl implements SpreadsheetService{
    @Autowired
    private SpreadsheetDao spreadsheetDao;
    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetServiceImpl.class);

    @Override
    public Spreadsheet save(Spreadsheet entity) {
        return spreadsheetDao.save(entity);
    }

    @Override
    public Spreadsheet update(Spreadsheet entity) {
        return spreadsheetDao.update(entity);
    }

    @Override
    public Spreadsheet getById(Long id) {
        Spreadsheet spreadsheet = spreadsheetDao.getById(id);
        spreadsheet.getSpreadsheetCells().size(); // initialize lazy collection
        return spreadsheet;
    }

    @Override
    public List<Spreadsheet> getAll() {
        return spreadsheetDao.getAll();
    }

    @Override
    public List<Spreadsheet> getAllSpreasheetWithoutCells() {
        List<Spreadsheet> spreadsheets = spreadsheetDao.getAll();
        spreadsheets.forEach(spreadsheet -> spreadsheet.setSpreadsheetCells(null));
        return spreadsheets;
    }

    @Override
    public void removeById(Long id) {
        spreadsheetDao.removeById(id);
    }
}
