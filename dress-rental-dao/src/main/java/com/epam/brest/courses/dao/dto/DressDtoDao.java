package com.epam.brest.courses.dao.dto;

import com.epam.brest.courses.model.dto.DressDto;

import java.util.List;

/**
 * A simple DAO interface to handle the database operation
 * required to manipulate a DressDto model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public interface DressDtoDao {

    /**
     * Finds all dresses with numbers of orders.
     *
     * @return dresses list.
     */
    List<DressDto> findAllWithNumberOfOrders();
}
