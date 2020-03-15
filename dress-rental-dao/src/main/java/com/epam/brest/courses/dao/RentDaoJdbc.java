package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Optional;

import static com.epam.brest.courses.constants.RentConstants.*;

public class RentDaoJdbc implements RentDao {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(RentDaoJdbc.class);

    @Value("${rent.findAll}")
    private String findAllSql;

    @Value("${rent.findById}")
    private String findByIdSql;

    @Value("${rent.create}")
    private String createSql;

    @Value("${rent.update}")
    private String updateSql;

    @Value("${rent.delete}")
    private String deleteSql;

    private final BeanPropertyRowMapper<Rent> rentRowMapper
            = BeanPropertyRowMapper.newInstance(Rent.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public RentDaoJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rent> findAll() {
        LOGGER.debug("Find all rents");
        List<Rent> rents = jdbcTemplate.query(findAllSql, rentRowMapper);
        return rents;
    }

    @Override
    public Optional<Rent> findById(Integer rentId) {
        LOGGER.debug("Find rent by id {}", rentId);
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(RENT_ID, rentId);
        List<Rent> result = jdbcTemplate
                .query(findByIdSql, namedParameters, rentRowMapper);
        return Optional.ofNullable(DataAccessUtils.uniqueResult(result));
    }

    @Override
    public Integer create(Rent rent) {
        LOGGER.debug("Create new rent {}", rent);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue(CLIENT, rent.getClient());
        namedParameters.addValue(RENT_DATE, rent.getRentDate());
        namedParameters.addValue(DRESS_ID, rent.getDressId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(createSql, namedParameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer update(Rent rent) {
        LOGGER.debug("Update rent {}", rent);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue(RENT_ID, rent.getRentId());
        namedParameters.addValue(CLIENT, rent.getClient());
        namedParameters.addValue(RENT_DATE, rent.getRentDate());
        namedParameters.addValue(DRESS_ID, rent.getDressId());
        return jdbcTemplate.update(updateSql, namedParameters);
    }

    @Override
    public Integer delete(Integer rentId) {
        LOGGER.debug("Delete rent with id = {}", rentId);
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(RENT_ID, rentId);
        return jdbcTemplate.update(deleteSql, namedParameters);
    }
}
