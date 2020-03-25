package com.epam.brest.courses.service.dto;

import com.epam.brest.courses.dao.dto.DressDtoDao;
import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service_api.dto.DressDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * A service class that defines how to work
 * with the DressDto model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class DressDtoServiceImpl implements DressDtoService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DressDtoServiceImpl.class);

    /**
     * A dressDto data access object.
     */
    private final DressDtoDao dressDtoDao;

    /**
     * Constructs new object with given DAO object.
     *
     * @param dressDtoDao rent DAO.
     */
    public DressDtoServiceImpl(DressDtoDao dressDtoDao) {
        this.dressDtoDao = dressDtoDao;
    }

    /**
     * Finds dresses with number of orders.
     *
     * @return dresses with number of orders.
     */
    @Override
    public List<DressDto> findAllWithNumberOfOrders() {
        LOGGER.debug("Find all dresses with number of orders");
        return dressDtoDao.findAllWithNumberOfOrders();
    }
}
