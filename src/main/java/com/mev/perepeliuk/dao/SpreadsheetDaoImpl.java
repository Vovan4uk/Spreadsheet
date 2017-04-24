package com.mev.perepeliuk.dao;

import com.mev.perepeliuk.domain.Spreadsheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SpreadsheetDaoImpl extends GenericDaoImpl<Spreadsheet> implements SpreadsheetDao {
    private static final Logger logger = LoggerFactory.getLogger(SpreadsheetDaoImpl.class);

    public SpreadsheetDaoImpl() {
        super(Spreadsheet.class);
    }
}
