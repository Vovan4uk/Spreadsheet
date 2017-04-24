package com.mev.perepeliuk.service;

import com.mev.perepeliuk.dao.SpreadsheetCellDao;
import com.mev.perepeliuk.domain.SpreadsheetCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpreadsheetCellServiceImpl implements SpreadsheetCellService{
    @Autowired
    private SpreadsheetCellDao spreadsheetCellDao;
    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetCellServiceImpl.class);

    @Override
    public SpreadsheetCell save(SpreadsheetCell entity) {
        return spreadsheetCellDao.save(entity);
    }

    @Override
    public SpreadsheetCell update(SpreadsheetCell entity) {
        return spreadsheetCellDao.update(entity);
    }

    @Override
    public SpreadsheetCell getById(Long id) {
         return spreadsheetCellDao.getById(id);
    }

    @Override
    public List<SpreadsheetCell> getAll() {
        return spreadsheetCellDao.getAll();
    }

    @Override
    public void removeById(Long id) {
        spreadsheetCellDao.removeById(id);
    }
}
