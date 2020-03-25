package com.epam.brest.courses.service_api.dto;

import com.epam.brest.courses.model.dto.DressDto;

import java.util.List;

/**
 * A a service interface that defines the methods
 * of working with the DressDto model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public interface DressDtoService {

    /**
     * Finds all dresses with numbers of orders.
     *
     * @return dresses list.
     */
    List<DressDto> findAllWithNumberOfOrders();
}
