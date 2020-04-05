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

import java.util.*;

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
     * The database query to check if name is unique.
     */
    @Value("${dress.uniqueName}")
    private String uniqueNameSql;

    /**
     * The database query to check if the dress has orders.
     */
    @Value("${dress.dressOrders}")
    private String dressOrdersSql;

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
        return jdbcTemplate.query(findAllSql, dressRowMapper);
    }

    /**
     * Finds dress by ID.
     *
     * @param dressId dress Id.
     * @return a Optional description of the dress found.
     */
    @Override
    public Optional<Dress> findById(Integer dressId) {
        LOGGER.debug("Find dress by ID {}", dressId);
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
        if (isNameAlreadyExist(dress)) {
            throw new IllegalArgumentException(
                    "Dress with the same name is already exists in DB.");
        }

        SqlParameterSource namedParameters
                = new MapSqlParameterSource(DRESS_NAME, dress.getDressName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(createSql, namedParameters, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
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
        if (isNameAlreadyExist(dress)) {
            throw new IllegalArgumentException(
                    "Dress with the same name is already exists in DB.");
        }

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
        if (isDressHasRents(dressId)) {
            throw new UnsupportedOperationException(
                    "This dress has orders and cannot be removed.");
        }

        SqlParameterSource namedParameters
                = new MapSqlParameterSource(DRESS_ID, dressId);
        return jdbcTemplate.update(deleteSql, namedParameters);
    }

    /**
     * Checks if the name of the dress is already exist.
     *
     * @param dress dress.
     * @return the boolean value of the existence of a name.
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public Boolean isNameAlreadyExist(Dress dress) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (dress.getDressId() == null) {
            parameterSource.addValue(DRESS_ID, 0);
        } else {
            parameterSource.addValue(DRESS_ID, dress.getDressId());
        }
        parameterSource.addValue(DRESS_NAME, dress.getDressName());
        return jdbcTemplate.queryForObject(uniqueNameSql, parameterSource,
                Integer.class) != 0;
    }

    /**
     * Checks if the dress with a given ID has orders.
     *
     * @param dressId dress ID.
     * @return the boolean value is there a dress orders.
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public Boolean isDressHasRents(Integer dressId) {
        return jdbcTemplate.queryForObject(dressOrdersSql,
                new MapSqlParameterSource(DRESS_ID, dressId),
                Integer.class) > 0;
    }
}
