package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.RentDao;
import com.epam.brest.courses.model.Rent;
import com.epam.brest.courses.service_api.RentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentServiceImpl.class);

    private final RentDao rentDao;

    public RentServiceImpl(RentDao rentDao) {
        this.rentDao = rentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rent> findAll() {
        LOGGER.debug("Find all rents");
        return rentDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Rent> findById(Integer rentId) {
        LOGGER.debug("Find rent by id {}", rentId);
        return rentDao.findById(rentId);
    }

    @Override
    public Integer create(Rent rent) {
        LOGGER.debug("Create new rent {}", rent);
        return rentDao.create(rent);
    }

    @Override
    public Integer update(Rent rent) {
        LOGGER.debug("Update rent {}", rent);
        return rentDao.update(rent);
    }

    @Override
    public Integer delete(Integer rentId) {
        LOGGER.debug("Delete rent with id = {}", rentId);
        return rentDao.delete(rentId);
    }

}
