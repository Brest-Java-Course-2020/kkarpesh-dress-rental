package com.epam.brest.courses.dao.dto;

import com.epam.brest.courses.dao.DressDaoJdbc;
import com.epam.brest.courses.model.dto.DressDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class DressDtoDaoJdbc implements DressDtoDao {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DressDaoJdbc.class);

    @Value("${dressDto.findAllWithNumberOfOrders")
    private String findAllWithNumberOfOrdersSql;


    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DressDtoDaoJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DressDto> findAllWithNumberOfOrders() {
        LOGGER.debug("Find all rents with number of orders");
        List<DressDto> dresses = jdbcTemplate
                .query(findAllWithNumberOfOrdersSql,
                        BeanPropertyRowMapper.newInstance(DressDto.class));
        return dresses;
    }
}
