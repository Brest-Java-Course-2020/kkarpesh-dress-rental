package com.epam.brest.courses.service.dto;

import com.epam.brest.courses.dao.dto.RentDtoDao;
import com.epam.brest.courses.model.dto.RentDto;
import com.epam.brest.courses.service_api.dto.RentDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RentDtoServiceImpl implements RentDtoService {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(RentDtoServiceImpl.class);

    private final RentDtoDao rentDtoDao;

    public RentDtoServiceImpl(RentDtoDao rentDtoDao) {
        this.rentDtoDao = rentDtoDao;
    }

    @Override
    public List<RentDto> findAllWIthDressNameByDate(LocalDate dateFrom,
                                                    LocalDate dateTo) {
        LOGGER.debug("Find all rents with dress name from {} to {}",
                dateFrom,
                dateTo);
        if (dateFrom == null) {
            dateFrom = LocalDate.MIN;
        }
        if (dateTo == null) {
            dateTo = LocalDate.MAX;
        }
        return rentDtoDao.findAllWIthDressNameByDate(dateFrom, dateTo);
    }
}
