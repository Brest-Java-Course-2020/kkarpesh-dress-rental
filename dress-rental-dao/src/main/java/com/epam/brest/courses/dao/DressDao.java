package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Dress;

import java.util.List;
import java.util.Optional;

/**
 * A simple DAO interface to handle the database operation
 * required to manipulate a Dress entity.
 */
public interface DressDao {

    /**
     * Find all dresses.
     *
     * @return dresses list.
     */
    List<Dress> findAll();

    /**
     * Find dress by Id.
     *
     * @param dressId dress Id.
     * @return dress.
     */
    Optional<Dress> findById(Integer dressId);

    /**
     * Create new dress.
     *
     * @param dress dress.
     * @return created dress Id.
     */
    Integer create(Dress dress);

    /**
     * Update dress.
     *
     * @param dress dress.
     * @return number of updated records in the database.
     */
    Integer update(Dress dress);

    /**
     * Delete dress.
     *
     * @param dressId dress Id.
     * @return number of deleted records in the database.
     */
    Integer delete(Integer dressId);
}
