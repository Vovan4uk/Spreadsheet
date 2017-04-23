package com.mev.perepeliuk.service;

import com.mev.perepeliuk.controller.SpreadsheetController;
import com.mev.perepeliuk.dao.FunctionCategoryDao;
import com.mev.perepeliuk.domain.FunctionCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FunctionCategoryServiceImpl implements FunctionCategoryService{
    @Autowired
    private FunctionCategoryDao functionCategoryDao;
    private static final Logger logger = LoggerFactory.getLogger(FunctionCategoryServiceImpl.class);

    @Override
    public FunctionCategory save(FunctionCategory entity) {
        return functionCategoryDao.save(entity);
    }

    @Override
    public FunctionCategory update(FunctionCategory entity) {
        return functionCategoryDao.update(entity);
    }

    @Override
    public FunctionCategory getById(Long id) {
        return functionCategoryDao.getById(id);
    }

    @Override
    public List<FunctionCategory> getAll() {
        return functionCategoryDao.getAll();
    }
}
