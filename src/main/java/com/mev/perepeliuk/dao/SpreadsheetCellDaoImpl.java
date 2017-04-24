package com.mev.perepeliuk.dao;

import com.mev.perepeliuk.domain.SpreadsheetCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SpreadsheetCellDaoImpl extends GenericDaoImpl<SpreadsheetCell> implements SpreadsheetCellDao {
    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetCellDaoImpl.class);

    public SpreadsheetCellDaoImpl() {
        super(SpreadsheetCell.class);
    }
}
