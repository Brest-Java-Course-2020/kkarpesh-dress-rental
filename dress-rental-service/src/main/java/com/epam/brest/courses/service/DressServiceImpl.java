package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.DressDao;
import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.service_api.DressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * A service class that defines how to work
 * with the Dress model.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional
public class DressServiceImpl implements DressService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DressServiceImpl.class);

    /**
     * A dress data access object.
     */
    private final DressDao dressDao;

    /**
     * Constructs new object with given DAO object.
     *
     * @param dressDao dress DAO.
     */
    public DressServiceImpl(DressDao dressDao) {
        this.dressDao = dressDao;
    }

    /**
     * Finds all dresses.
     *
     * @return dresses list.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Dress> findAll() {
        LOGGER.debug("Find all dresses");
        return dressDao.findAll();
    }

    /**
     * Finds dress by Id.
     *
     * @param dressId dress Id.
     * @return a Optional description of the dress found.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Dress> findById(Integer dressId) {
        LOGGER.debug("Find dress with id = {}", dressId);
        return dressDao.findById(dressId);
    }

    /**
     * Creates new dress.
     *
     * @param dress dress.
     * @return created dress Id.
     */
    @Override
    public Integer create(Dress dress) {
        LOGGER.debug("Create new dress {}", dress);
        return dressDao.create(dress);
    }

    /**
     * Updates dress.
     *
     * @param dress dress.
     * @return number of updated records in the database.
     */
    @Override
    public Integer update(Dress dress) {
        LOGGER.debug("Update dress {}", dress);
        return dressDao.update(dress);
    }

    /**
     * Deletes dress.
     *
     * @param dressId dress Id.
     * @return number of deleted records in the database.
     */
    @Override
    public Integer delete(Integer dressId) {
        LOGGER.debug("Delete dress by id = {}", dressId);
        return dressDao.delete(dressId);
    }

    /**
     * Checks if the name of the dress is already exist.
     *
     * @param dress dress.
     * @return the boolean value of the existence of a name.
     */
    @Override
    @Transactional(readOnly = true)
    public Boolean isNameAlreadyExist(Dress dress) {
        LOGGER.debug("is name exists - {}", dress);
        return dressDao.isNameAlreadyExist(dress);
    }

    /**
     * Checks if the dress with a given ID has orders.
     *
     * @param dressId dress ID.
     * @return the boolean value is there a dress orders.
     */
    @Override
    @Transactional(readOnly = true)
    public Boolean isDressHasRents(Integer dressId) {
        LOGGER.debug("is dress id={} has rents", dressId);
        return dressDao.isDressHasRents(dressId);
    }
}
