package com.epam.brest.courses.dao.dto;

import com.epam.brest.courses.dao.DressDaoJdbc;
import com.epam.brest.courses.dao.dto.RentDtoDao;
import com.epam.brest.courses.model.dto.RentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.time.LocalDate;
import java.util.List;

public class RentDtoDaoJdbc implements RentDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DressDaoJdbc.class);

    @Value("${rentDto.findAllWIthDressNameByDate}")
    private String findAllWIthDressNameSql;


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RentDtoDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<RentDto> findAllWIthDressNameByDate(LocalDate dateFrom, LocalDate dateTo) {
        LOGGER.debug("Find all rents with dress name from {} to {}", dateFrom, dateTo);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("dateFrom", dateFrom);
        namedParameters.addValue("dateTo", dateTo);
        List<RentDto> rents = namedParameterJdbcTemplate.query(findAllWIthDressNameSql, namedParameters, BeanPropertyRowMapper.newInstance(RentDto.class));
        return rents;
    }
}
