package com.epam.brest.courses.dao.dto;

import com.epam.brest.courses.model.dto.DressDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath*:dao.xml"})
class DressDtoDaoJdbcIT {

    private static final int NUMBER_OF_DRESSES = 5;
    private static final Integer DRESS_ID = 5;
    private static final String DRESS_NAME = "Floral print dress";
    private static final Integer NUMBER_OF_ORDERS = 1;

    @Autowired
    private DressDtoDao dressDtoDao;

    @Test
    void findAllWithNumberOfOrders() {
        List<DressDto> dresses = dressDtoDao.findAllWithNumberOfOrders();
        assertEquals(NUMBER_OF_DRESSES, dresses.size());

        DressDto dressDtoFromQuery = dresses.get(0);
        assertEquals(DRESS_ID, dressDtoFromQuery.getDressId());
        assertEquals(DRESS_NAME, dressDtoFromQuery.getDressName());
        assertEquals(NUMBER_OF_ORDERS, dressDtoFromQuery.getNumberOfOrders());


    }
}