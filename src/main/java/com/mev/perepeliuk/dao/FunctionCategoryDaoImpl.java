package com.mev.perepeliuk.dao;

import com.mev.perepeliuk.domain.FunctionCategory;
import com.mev.perepeliuk.service.FunctionCategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FunctionCategoryDaoImpl extends GenericDaoImpl<FunctionCategory> implements FunctionCategoryDao {
    private static final Logger logger = LoggerFactory.getLogger(FunctionCategoryDaoImpl.class);

    public FunctionCategoryDaoImpl() {
        super(FunctionCategory.class);
    }
}
