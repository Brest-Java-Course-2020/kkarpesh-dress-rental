package com.epam.brest.courses.dao;


import com.epam.brest.courses.model.Dress;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.epam.brest.courses.constants.DressConstants.*;

public class DressDaoJdbc implements DressDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DressDaoJdbc.class);

    @Value("${dress.findAll}")
    private String findAllSql;

    @Value("${dress.findById}")
    private String findByIdSql;

    @Value("${dress.create}")
    private String createSql;

    @Value("${dress.update}")
    private String updateSql;

    @Value("${dress.delete}")
    private String deleteSql;

    private final BeanPropertyRowMapper<Dress> dressRowMapper = BeanPropertyRowMapper.newInstance(Dress.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DressDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Dress> findAll() {
        LOGGER.debug("Get all dresses");
        List<Dress> dresses = namedParameterJdbcTemplate.query(findAllSql, dressRowMapper);
        return dresses;
    }

    @Override
    public Optional<Dress> findById(Integer dressId) {
        LOGGER.debug("Find dress by ID {}, dressId");
        SqlParameterSource namedParameters = new MapSqlParameterSource(DRESS_ID, dressId);
        List<Dress> dresses = namedParameterJdbcTemplate.query(findByIdSql, namedParameters, dressRowMapper);
        return Optional.ofNullable(DataAccessUtils.uniqueResult(dresses));
    }

    @Override
    public Integer create(Dress dress) {
        LOGGER.debug("Create new dress {}", dress);
        SqlParameterSource namedParameters = new MapSqlParameterSource(DRESS_NAME, dress.getDressName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(createSql, namedParameters,keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer update(Dress dress) {
        LOGGER.debug("Update dress {}", dress);
        Map<String,Object> namedParameters = new HashMap<>();
        namedParameters.put(DRESS_ID, dress.getDressId());
        namedParameters.put(DRESS_NAME, dress.getDressName());
        return namedParameterJdbcTemplate.update(updateSql, namedParameters);

    }

    @Override
    public Integer delete(Integer dressId) {
        LOGGER.debug("Delete dress with id = {}", dressId);
        SqlParameterSource namedParameters = new MapSqlParameterSource(DRESS_ID, dressId);
        return namedParameterJdbcTemplate.update(deleteSql,namedParameters);
    }

}
