package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.RentDao;
import com.epam.brest.courses.model.Rent;
import com.epam.brest.courses.service_api.RentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * A service class that defines how to work
 * with the Rent model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional
public class RentServiceImpl implements RentService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(RentServiceImpl.class);

    /**
     * A rent data access object.
     */
    private final RentDao rentDao;

    /**
     * Constructs new object with given DAO object.
     *
     * @param rentDao rent DAO.
     */
    public RentServiceImpl(RentDao rentDao) {
        this.rentDao = rentDao;
    }

    /**
     * Finds all rents.
     *
     * @return rents list.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Rent> findAll() {
        LOGGER.debug("Find all rents");
        return rentDao.findAll();
    }

    /**
     * Finds rent by Id.
     *
     * @param rentId rent Id.
     * @return a Optional description of the rent found.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Rent> findById(Integer rentId) {
        LOGGER.debug("Find rent by id {}", rentId);
        return rentDao.findById(rentId);
    }

    /**
     * Creates new rent.
     *
     * @param rent dress.
     * @return created rent Id.
     */
    @Override
    public Integer create(Rent rent) {
        LOGGER.debug("Create new rent {}", rent);
        return rentDao.create(rent);
    }

    /**
     * Updates rent.
     *
     * @param rent rent.
     * @return number of updated records in the database.
     */
    @Override
    public Integer update(Rent rent) {
        LOGGER.debug("Update rent {}", rent);
        return rentDao.update(rent);
    }

    /**
     * Deletes rent.
     *
     * @param rentId rent Id.
     * @return number of deleted records in the database.
     */
    @Override
    public Integer delete(Integer rentId) {
        LOGGER.debug("Delete rent with id = {}", rentId);
        return rentDao.delete(rentId);
    }

    /**
     * Checks if dress rented for this date.
     *
     * @param rent rent.
     * @return true if dress has already been rented
     * for this date and false if not.
     */
    @Override
    @Transactional(readOnly = true)
    public Boolean hasDressAlreadyBeenRentedForThisDate(Rent rent) {
        LOGGER.debug("is rent exists - {}", rent);
        return rentDao.hasDressAlreadyBeenRentedForThisDate(rent);
    }

}
