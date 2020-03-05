package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Dress;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import static com.epam.brest.courses.constants.DressConstants.*;

public class DressRowMapper implements RowMapper<Dress> {

    @Override
    public Dress mapRow(ResultSet resultSet, int i) throws SQLException {
        Dress dress = new Dress();
        dress.setDressId(resultSet.getInt(COLUMN_DRESS_ID));
        dress.setDressName(resultSet.getString(COLUMN_DRESS_NAME));
        return dress;
    }
}
