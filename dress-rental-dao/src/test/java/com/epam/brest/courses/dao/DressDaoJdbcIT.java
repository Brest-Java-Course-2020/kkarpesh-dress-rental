package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Dress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath*:dao.xml"})
class DressDaoJdbcIT {

    private final DressDao dressDao;

    @Autowired
    public DressDaoJdbcIT(DressDao dressDao) {
        this.dressDao = dressDao;
    }

    @Test
    void shouldFindAllDresses() {
        List<Dress> dresses = dressDao.findAll();
        assertNotNull(dresses);
        assertTrue(dresses.size()>0);
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