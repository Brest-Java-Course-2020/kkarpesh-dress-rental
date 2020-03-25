package com.epam.brest.courses.service_api.dto;

import com.epam.brest.courses.model.dto.RentDto;

import java.time.LocalDate;
import java.util.List;

/**
 * A a service interface that defines the methods
 * of working with the RentDto model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public interface RentDtoService {

    /**
     * Finds rents with dress name for the specified period.
     *
     * @param dateFrom period start date.
     * @param dateTo period finish date.
     * @return rents list with dress name for the specified period.
     */
    List<RentDto> findAllWIthDressNameByDate(LocalDate dateFrom,
                                             LocalDate dateTo);
}
