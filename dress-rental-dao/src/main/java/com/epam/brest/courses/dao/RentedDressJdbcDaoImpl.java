package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;
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
    public List<Rent> getRentedDresses() {
        return null;
    }

    @Override
    public Rent getRentedDressById(Integer rentedDressId) {
        return null;
    }

    @Override
    public List<Rent> getRentedDressesByDate(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public Rent addRentedDress(Rent rent) {
        return null;
    }

    @Override
    public void updateRentedDress(Rent rent) {

    }

    @Override
    public void deleteRentedDress(Integer rentedDressId) {

    }
}
