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

/**
 * A service class that defines how to work
 * with the RentDto model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class RentDtoServiceImpl implements RentDtoService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(RentDtoServiceImpl.class);

    /**
     * A rentDto data access object.
     */
    private final RentDtoDao rentDtoDao;

    /**
     * Constructs new object with given DAO object.
     *
     * @param rentDtoDao rent DAO.
     */
    public RentDtoServiceImpl(RentDtoDao rentDtoDao) {
        this.rentDtoDao = rentDtoDao;
    }

    /**
     * Finds rents with dress name for a given period of time.
     *
     * @param dateFrom period start date.
     * @param dateTo period finish date.
     * @return rents with dress name for a given period of time.
     */
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
