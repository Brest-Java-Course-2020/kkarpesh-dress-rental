package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.DressDao;
import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.service_api.DressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DressServiceImpl implements DressService {

    private final static Logger LOGGER
            = LoggerFactory.getLogger(DressServiceImpl.class);

    private final DressDao dressDao;

    public DressServiceImpl(DressDao dressDao) {
        this.dressDao = dressDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dress> findAll() {
        LOGGER.debug("Find all dresses");
        return dressDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Dress> findById(Integer dressId) {
        LOGGER.debug("Find dress with id = {}", dressId);
        return dressDao.findById(dressId);
    }

    @Override
    public Integer create(Dress dress) {
        LOGGER.debug("Create new dress {}", dress);
        return dressDao.create(dress);
    }

    @Override
    public Integer update(Dress dress) {
        LOGGER.debug("Update dress {}", dress);
        return dressDao.update(dress);
    }

    @Override
    public Integer delete(Integer dressId) {
        LOGGER.debug("Delete dress by id = {}", dressId);
        return dressDao.delete(dressId);
    }
}
