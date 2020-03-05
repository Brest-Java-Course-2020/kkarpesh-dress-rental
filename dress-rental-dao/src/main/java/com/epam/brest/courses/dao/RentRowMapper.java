package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.brest.courses.constants.RentConstants.*;

public class RentRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Rent rent = new Rent();
        rent.setRentId(resultSet.getInt(COLUMN_RENT_ID));
        rent.setClient(resultSet.getString(COLUMN_CLIENT));
        rent.setRentDate(resultSet.getDate(COLUMN_RENT_DATE));
        rent.setDressId(resultSet.getInt(COLUMN_DRESS_ID));
        return rent;
    }
}
