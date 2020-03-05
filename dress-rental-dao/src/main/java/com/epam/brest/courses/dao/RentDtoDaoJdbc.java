package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.dto.RentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class RentDtoDaoJdbc implements RentDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DressDaoJdbc.class);

    @Value("${rentDto.findAllWIthDressName")
    private String findAllWIthDressNameSql;


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RentDtoDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<RentDto> findAllWIthDressName() {
        LOGGER.debug("Find all rents with number of orders");
        List<RentDto> rents = namedParameterJdbcTemplate.query(findAllWIthDressNameSql, BeanPropertyRowMapper.newInstance(RentDto.class));
        return rents;
    }
}
