package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.dto.DressDto;

import java.util.List;

public interface DressDtoDao {

    /**
     * Find all dresses with numbers of orders.
     *
     * @return dresses list.
     */
    List <DressDto> findAllWithNumberOfOrders();
}
