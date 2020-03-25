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

/**
 * This class contains methods for direct access
 * to data source using JDBC driver.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public class DressDaoJdbc implements DressDao {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DressDaoJdbc.class);

    /**
     * The database query to find all dresses.
     */
    @Value("${dress.findAll}")
    private String findAllSql;

    /**
     * The database query to find dress by ID.
     */
    @Value("${dress.findById}")
    private String findByIdSql;

    /**
     * The database query to create a new dress.
     */
    @Value("${dress.create}")
    private String createSql;

    /**
     * The database query to update existing dress.
     */
    @Value("${dress.update}")
    private String updateSql;

    /**
     * The database query to delete a dress.
     */
    @Value("${dress.delete}")
    private String deleteSql;

    /**
     * Mapper to convert a row into a new instance of the dress.
     */
    private final BeanPropertyRowMapper<Dress> dressRowMapper
            = BeanPropertyRowMapper.newInstance(Dress.class);

    /**
     * Jdbc template to execute actions to data source.
     */
    private final NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Constructs a new object with given JDBC template.
     *
     * @param jdbcTemplate jdbc template.
     */
    public DressDaoJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Finds all dresses.
     *
     * @return all dresses.
     */
    @Override
    public List<Dress> findAll() {
        LOGGER.debug("Get all dresses");
        List<Dress> dresses
                = jdbcTemplate.query(findAllSql, dressRowMapper);
        return dresses;
    }

    /**
     * Finds dress by ID.
     *
     * @param dressId dress Id.
     * @return a Optional description of the dress found.
     */
    @Override
    public Optional<Dress> findById(Integer dressId) {
        LOGGER.debug("Find dress by ID {}, dressId");
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(DRESS_ID, dressId);
        List<Dress> dresses = jdbcTemplate
                .query(findByIdSql, namedParameters, dressRowMapper);
        return Optional.ofNullable(DataAccessUtils.uniqueResult(dresses));
    }

    /**
     * Saves the dress to a data source.
     *
     * @param dress dress.
     * @return created dress ID.
     */
    @Override
    public Integer create(Dress dress) {
        LOGGER.debug("Create new dress {}", dress);
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(DRESS_NAME, dress.getDressName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(createSql, namedParameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * Updates an existing dress with a new object.
     *
     * @param dress dress.
     * @return number of updated records in the database.
     */
    @Override
    public Integer update(Dress dress) {
        LOGGER.debug("Update dress {}", dress);
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(DRESS_ID, dress.getDressId());
        namedParameters.put(DRESS_NAME, dress.getDressName());
        return jdbcTemplate.update(updateSql, namedParameters);

    }

    /**
     * Deletes dress from data source.
     *
     * @param dressId dress.
     * @return number of deleted records in the database.
     */
    @Override
    public Integer delete(Integer dressId) {
        LOGGER.debug("Delete dress with id = {}", dressId);
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(DRESS_ID, dressId);
        return jdbcTemplate.update(deleteSql, namedParameters);
    }

}
