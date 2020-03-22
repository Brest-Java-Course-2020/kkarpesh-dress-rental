package com.epam.brest.courses.dao.dto;

import com.epam.brest.courses.model.dto.RentDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath*:dao.xml"})
class RentDtoDaoJdbcIT {

    @Autowired
    private RentDtoDao rentDtoDao;

    @Test
    void findAllWIthDressNameByDate() {
        LocalDate dateFrom = LocalDate.of(2019, 01, 01);
        LocalDate dateTo = LocalDate.of(2020, 01, 01);
        List<RentDto> rents = rentDtoDao.findAllWIthDressNameByDate(dateFrom, dateTo);
        System.out.println(rents.toString());
        assertTrue(rents.size()==2);
    }

}