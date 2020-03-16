package com.epam.brest.courses.dao;


import com.epam.brest.courses.model.Dress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DressJdbcDaoImpl implements DressDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DressJdbcDaoImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String ALL_DRESSES = "SELECT d.dressId, d.dressName FROM dress d ORDER BY d.dressName";
    private static final String DRESS_BY_ID = "SELECT d.dressId, d.dressName FROM dress d WHERE dressId = :dressId";

    public DressJdbcDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Dress> getDresses() {
        LOGGER.debug("Get all dresses");
        List <Dress> dresses = namedParameterJdbcTemplate.query(ALL_DRESSES, new DressRowMapper());
        return dresses;
    }

    @Override
    public Dress getDressById(Integer dressId) {
        LOGGER.debug("Get dress by ID {}, dressId");
        Dress dress = namedParameterJdbcTemplate.queryForObject(DRESS_BY_ID, new MapSqlParameterSource("dressId", dressId), new DressRowMapper());
        return dress;
    }

    @Override
    public Dress addDress(Dress dress) {
        return null;
    }

    @Override
    public void updateDress(Dress dress) {

    }

    @Override
    public void deleteDress(Integer dressId) {

    }

    private class DressRowMapper implements RowMapper<Dress> {

        @Override
        public Dress mapRow(ResultSet resultSet, int i) throws SQLException {
            Dress dress = new Dress();
            dress.setDressId(resultSet.getInt("dressId"));
            dress.setDressName(resultSet.getString("dressName"));
            return dress;
        }
    }
}
