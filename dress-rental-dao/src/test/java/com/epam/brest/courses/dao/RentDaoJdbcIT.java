package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath*:dao.xml"})
class RentDaoJdbcIT {

    private final RentDao rentDao;

    @Autowired
    public RentDaoJdbcIT(RentDao rentDao) {
        this.rentDao = rentDao;
    }

    @Test
        void shouldFindAllRents() {
            List<Rent> rents = rentDao.findAll();
            assertNotNull(rents);
            assertTrue(rents.size()>0);
        }
    @Test
    void create() {
        Rent rent = new Rent();
        rent.setDressId(1);
        rent.setClient("Marya");
        rent.setRentDate(LocalDate.now());
        assertTrue(rentDao.create(rent)==6);

    }
}