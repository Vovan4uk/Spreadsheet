package com.mev.perepeliuk.dao;

import com.mev.perepeliuk.domain.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FunctionDaoImpl extends GenericDaoImpl<Function> implements FunctionDao {
    private static final Logger logger = LoggerFactory.getLogger(FunctionDaoImpl.class);

    public FunctionDaoImpl() {
        super(Function.class);
    }
}
