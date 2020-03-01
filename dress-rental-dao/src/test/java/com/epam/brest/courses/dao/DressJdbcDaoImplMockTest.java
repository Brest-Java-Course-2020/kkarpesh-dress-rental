package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Dress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DressJdbcDaoImplMockTest {

    @InjectMocks
    private DressJdbcDaoImpl dressJdbcDao;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @AfterEach
    void after(){
        Mockito.verifyNoMoreInteractions(namedParameterJdbcTemplate);
    }

    @Test
    void getDresses() {
    }

    @Test
    void getDressById() {
    }

    @Test
    void addDress() {
    }

    @Test
    void updateDress() {
    }

    @Test
    void deleteDress() {
    }
}