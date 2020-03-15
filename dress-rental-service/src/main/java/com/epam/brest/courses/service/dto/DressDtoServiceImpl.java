package com.epam.brest.courses.service.dto;

import com.epam.brest.courses.dao.dto.DressDtoDao;
import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service_api.dto.DressDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DressDtoServiceImpl implements DressDtoService {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DressDtoServiceImpl.class);

    private final DressDtoDao dressDtoDao;

    public DressDtoServiceImpl(DressDtoDao dressDtoDao) {
        this.dressDtoDao = dressDtoDao;
    }

    @Override
    public List<DressDto> findAllWithNumberOfOrders() {
        LOGGER.debug("Find all dresses with number of orders");
        return dressDtoDao.findAllWithNumberOfOrders();
    }
}
