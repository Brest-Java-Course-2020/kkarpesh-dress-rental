package com.epam.brest.courses.service_api.dto;

import com.epam.brest.courses.model.dto.DressDto;

import java.util.List;

public interface DressDtoService {

    /**
     * Find all dresses with numbers of orders.
     *
     * @return dresses list.
     */
    List<DressDto> findAllWithNumberOfOrders();
}
