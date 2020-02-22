package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.RentedDress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Date;
import java.util.List;

public class RentedDressJdbcDaoImpl implements RentedDressDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentedDressJdbcDaoImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RentedDressJdbcDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<RentedDress> getRentedDresses() {
        return null;
    }

    @Override
    public RentedDress getRentedDressById(Integer rentedDressId) {
        return null;
    }

    @Override
    public List<RentedDress> getRentedDressesByDate(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public RentedDress addRentedDress(RentedDress rentedDress) {
        return null;
    }

    @Override
    public void updateRentedDress(RentedDress rentedDress) {

    }

    @Override
    public void deleteRentedDress(Integer rentedDressId) {

    }
}
