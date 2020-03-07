package com.epam.brest.courses.dao.dto;

import com.epam.brest.courses.model.dto.RentDto;

import java.util.List;

public interface RentDtoDao {

    /**
     * Find all rents with dress name.
     *
     * @return rents list.
     */
    List<RentDto> findAllWIthDressName();
}
