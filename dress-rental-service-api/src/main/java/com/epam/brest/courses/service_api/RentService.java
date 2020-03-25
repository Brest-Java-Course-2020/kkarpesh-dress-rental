package com.epam.brest.courses.service_api;

import com.epam.brest.courses.model.Rent;

import java.util.List;
import java.util.Optional;

/**
 * A a service interface that defines the methods
 * of working with the Rent model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public interface RentService {

    /**
     * Finds all rents.
     *
     * @return rents list.
     */
    List<Rent> findAll();

    /**
     * Finds rent by Id.
     *
     * @param rentId rent Id.
     * @return dress
     */
    Optional<Rent> findById(Integer rentId);

    /**
     * Creates new rent.
     *
     * @param rent dress.
     * @return created rent Id.
     */
    Integer create(Rent rent);

    /**
     * Updates rent.
     *
     * @param rent rent.
     * @return number of updated records in the database.
     */
    Integer update(Rent rent);

    /**
     * Deletes rent.
     *
     * @param rentId rent Id.
     * @return number of deleted records in the database.
     */
    Integer delete(Integer rentId);
}
