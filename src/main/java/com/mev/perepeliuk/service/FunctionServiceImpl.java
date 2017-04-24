package com.mev.perepeliuk.service;

import com.mev.perepeliuk.dao.FunctionDao;
import com.mev.perepeliuk.domain.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FunctionServiceImpl implements FunctionService{
    @Autowired
    private FunctionDao functionDao;
    private static final Logger logger = LoggerFactory.getLogger(FunctionServiceImpl.class);

    @Override
    public Function save(Function entity) {
        return functionDao.save(entity);
    }

    @Override
    public Function update(Function entity) {
        return functionDao.update(entity);
    }

    @Override
    public Function getById(Long id) {
        return functionDao.getById(id);
    }

    @Override
    public List<Function> getAll() {
        return functionDao.getAll();
    }

    @Override
    public void removeById(Long id) {
        functionDao.removeById(id);
    }
}
