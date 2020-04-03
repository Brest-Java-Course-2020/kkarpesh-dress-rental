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
import java.util.Objects;
import java.util.Optional;

import static com.epam.brest.courses.constants.RentConstants.*;

/**
 * This class contains methods for direct access
 * to data source using JDBC driver.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public class RentDaoJdbc implements RentDao {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(RentDaoJdbc.class);

    /**
     * The database query to find all rents.
     */
    @Value("${rent.findAll}")
    private String findAllSql;

    /**
     * The database query to find rent by ID.
     */
    @Value("${rent.findById}")
    private String findByIdSql;

    /**
     * The database query to create a new rent.
     */
    @Value("${rent.create}")
    private String createSql;

    /**
     * The database query to update existing rent.
     */
    @Value("${rent.update}")
    private String updateSql;

    /**
     * The database query to delete a rent.
     */
    @Value("${rent.delete}")
    private String deleteSql;

    /**
     * The database query to check if dress rented for this date.
     */
    @Value("${rent.uniqueOrder}")
    private String uniqueOrderSql;

    /**
     * Mapper to convert a row into a new instance of the rent.
     */
    private final BeanPropertyRowMapper<Rent> rentRowMapper
            = BeanPropertyRowMapper.newInstance(Rent.class);

    /**
     * Jdbc template to execute actions to data source.
     */
    private final NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Constructs a new object with given JDBC template.
     *
     * @param jdbcTemplate jdbc template.
     */
    public RentDaoJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Finds all rents.
     *
     * @return all rents.
     */
    @Override
    public List<Rent> findAll() {
        LOGGER.debug("Find all rents");
        List<Rent> rents = jdbcTemplate.query(findAllSql, rentRowMapper);
        return rents;
    }

    /**
     * Finds rent by ID.
     *
     * @param rentId rent ID.
     * @return a Optional description of the rent found.
     */
    @Override
    public Optional<Rent> findById(Integer rentId) {
        LOGGER.debug("Find rent by id {}", rentId);
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(RENT_ID, rentId);
        List<Rent> result = jdbcTemplate
                .query(findByIdSql, namedParameters, rentRowMapper);
        return Optional.ofNullable(DataAccessUtils.uniqueResult(result));
    }

    /**
     * Saves the rent to a data source.
     *
     * @param rent rent.
     * @return created rent ID.
     */
    @Override
    public Integer create(Rent rent) {
        LOGGER.debug("Create new rent {}", rent);
        if (hasDressAlreadyBeenRentedForThisDate(rent)) {
            throw new IllegalArgumentException(
                    "This dress has already been rented for this date."
            );
        }

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue(CLIENT, rent.getClient());
        namedParameters.addValue(RENT_DATE, rent.getRentDate());
        namedParameters.addValue(DRESS_ID, rent.getDressId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(createSql, namedParameters, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    /**
     * Updates an existing rent with a new object.
     *
     * @param rent rent.
     * @return number of updated records in the database.
     */
    @Override
    public Integer update(Rent rent) {
        LOGGER.debug("Update rent {}", rent);
        if (hasDressAlreadyBeenRentedForThisDate(rent)) {
            throw new IllegalArgumentException(
                    "This dress has already been rented for this date."
            );
        }

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue(RENT_ID, rent.getRentId());
        namedParameters.addValue(CLIENT, rent.getClient());
        namedParameters.addValue(RENT_DATE, rent.getRentDate());
        namedParameters.addValue(DRESS_ID, rent.getDressId());
        return jdbcTemplate.update(updateSql, namedParameters);
    }

    /**
     * Deletes rent from data source.
     *
     * @param rentId rent.
     * @return number of deleted records in the database.
     */
    @Override
    public Integer delete(Integer rentId) {
        LOGGER.debug("Delete rent with id = {}", rentId);
        SqlParameterSource namedParameters
                = new MapSqlParameterSource(RENT_ID, rentId);
        return jdbcTemplate.update(deleteSql, namedParameters);
    }

    /**
     * Checks if dress rented for this date.
     *
     * @param rent rent.
     * @return true if dress has already been rented
     * for this date and false if not.
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public Boolean hasDressAlreadyBeenRentedForThisDate(Rent rent) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(DRESS_ID, rent.getDressId());
        parameterSource.addValue(RENT_DATE, rent.getRentDate());
        return jdbcTemplate.queryForObject(uniqueOrderSql,
                parameterSource, Integer.class) != 0;
    }
}
