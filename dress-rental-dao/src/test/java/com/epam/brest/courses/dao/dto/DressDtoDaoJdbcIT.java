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

    @Autowired
    private DressDtoDao dressDtoDao;

    @Test
    void findAllWithNumberOfOrders() {
        DressDto dressDto = new DressDto();
        dressDto.setDressId(1);
        dressDto.setDressName("Dress 1");
        dressDto.setNumberOfOrders(2);

        List<DressDto> dresses = dressDtoDao.findAllWithNumberOfOrders();
        assertTrue(dresses.size()==5);

        DressDto dressDtoFromQuery = dresses.get(0);
        assertEquals(dressDtoFromQuery.getDressId(), dressDto.getDressId());
        assertEquals(dressDtoFromQuery.getDressName(), dressDto.getDressName());
        assertEquals(dressDtoFromQuery.getNumberOfOrders(), dressDto.getNumberOfOrders());


    }
}