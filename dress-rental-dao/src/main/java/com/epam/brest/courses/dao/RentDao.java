package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RentDao {

    /**
     * Find all rents.
     *
     * @return rents list.
     */
    List<Rent> findAll();

    /**
     * Find rent by Id.
     *
     * @param rentId rent Id.
     * @return dress
     */
    Optional<Rent> findById(Integer rentId);

    /**
     * Create new rent.
     *
     * @param rent dress.
     * @return created rent Id.
     */
    Integer create(Rent rent);

    /**
     * Update rent.
     *
     * @param rent rent.
     * @return number of updated records in the database.
     */
    Integer update(Rent rent);

    /**
     * Delete rent.
     *
     * @param rentId rent Id.
     * @return number of deleted records in the database.
     */
    Integer delete(Integer rentId);

    /**
     * Find rents by date.
     *
     * @param dateFrom period start date.
     * @param dateTo period finish date.
     * @return rents list for the specified period.
     */
    List <Rent> findRentsByDate(LocalDate dateFrom, LocalDate dateTo);
}
