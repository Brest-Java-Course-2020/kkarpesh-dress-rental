package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath*:dao.xml"})
@Transactional
class RentDaoJdbcIT {

    @Autowired
    private RentDao rentDao;

    private static final int NUMBER_OF_RENTS = 5;
    private static final int NUMBER_OF_RENTS_AFTER_CREATE = 6;
    private static final int NUMBER_OF_RENTS_AFTER_DELETE = 4;


    private static final Integer NONEXISTENT_RENT_ID = 6;
    private static final String NEW_RENT_CLIENT = "Larry Coster";
    private static final LocalDate NEW_RENT_DATE = LocalDate.of(2020, 2, 3);
    private static final Integer NEW_RENT_DRESS_ID = 3;

    private static final Integer EXISTING_RENT_ID = 2;
    private static final String EXISTING_RENT_CLIENT = "Emma Pavlova";
    private static final LocalDate EXISTING_RENT_DATE = LocalDate.of(2020, 2, 2);
    private static final Integer EXISTING_RENT_DRESS_ID = 2;

    private static final Integer UPDATED_RENT_ID = 3;
    private static final LocalDate UPDATED_RENT_DATE = LocalDate.of(2020, 1, 1);

    @Test
    void shouldFindAllRents() {
        List<Rent> rents = rentDao.findAll();
        assertNotNull(rents);
        assertEquals(NUMBER_OF_RENTS, rents.size());
    }

    @Test
    void shouldFindRentWithExistingId() {
        Optional<Rent> rent = rentDao.findById(EXISTING_RENT_ID);

        assertTrue(rent.isPresent());
        assertEquals(EXISTING_RENT_CLIENT, rent.get().getClient());
        assertEquals(EXISTING_RENT_DATE, rent.get().getRentDate());
        assertEquals(EXISTING_RENT_DRESS_ID, rent.get().getDressId());
    }

    @Test
    void shouldReturnNullWhenFindByNonexistentId() {
        Optional<Rent> rent = rentDao.findById(NONEXISTENT_RENT_ID);

        assertTrue(rent.isEmpty());
    }

    @Test
    void shouldCreateNewRent() {
        Rent newRent = new Rent();
        newRent.setClient(NEW_RENT_CLIENT);
        newRent.setRentDate(NEW_RENT_DATE);
        newRent.setDressId(NEW_RENT_DRESS_ID);

        Integer newRentId = rentDao.create(newRent);

        assertNotNull(newRentId);
        assertEquals(NUMBER_OF_RENTS_AFTER_CREATE, rentDao.findAll().size());

        Optional<Rent> createdRent = rentDao.findById(newRentId);

        assertTrue(createdRent.isPresent());
        assertEquals(NEW_RENT_CLIENT, createdRent.get().getClient());
        assertEquals(NEW_RENT_DATE, createdRent.get().getRentDate());
        assertEquals(NEW_RENT_DRESS_ID, createdRent.get().getDressId());

    }

    @Test
    void shouldThrowExceptionWhenCreateNewRentIfDressWasRentedOnThisDay() {
        Rent rentWithRecurringOrder = new Rent();
        rentWithRecurringOrder.setClient(NEW_RENT_CLIENT);
        rentWithRecurringOrder.setDressId(EXISTING_RENT_DRESS_ID);
        rentWithRecurringOrder.setRentDate(EXISTING_RENT_DATE);

        assertThrows(IllegalArgumentException.class, () -> {
            rentDao.create(rentWithRecurringOrder);
        });
    }

    @Test
    void shouldUpdatedRent() {
        Rent rent = new Rent();
        rent.setRentId(EXISTING_RENT_ID);
        rent.setClient(EXISTING_RENT_CLIENT);
        rent.setDressId(NEW_RENT_DRESS_ID);
        rent.setRentDate(UPDATED_RENT_DATE);

        assertEquals(Integer.valueOf(1), rentDao.update(rent));
        assertEquals(NUMBER_OF_RENTS, rentDao.findAll().size());

        Optional<Rent> updatedRent = rentDao.findById(EXISTING_RENT_ID);
        assertTrue(updatedRent.isPresent());
        assertEquals(EXISTING_RENT_CLIENT, updatedRent.get().getClient());
        assertEquals(NEW_RENT_DRESS_ID, updatedRent.get().getDressId());
        assertEquals(UPDATED_RENT_DATE, updatedRent.get().getRentDate());


    }

    @Test
    void shouldThrowExceptionWhenUpdateRentIfDressWasRentedOnThisDay() {
        Rent rentWithRecurringOrder = new Rent();
        rentWithRecurringOrder.setRentId(UPDATED_RENT_ID);
        rentWithRecurringOrder.setClient(NEW_RENT_CLIENT);
        rentWithRecurringOrder.setDressId(EXISTING_RENT_DRESS_ID);
        rentWithRecurringOrder.setRentDate(EXISTING_RENT_DATE);

        assertThrows(IllegalArgumentException.class, () -> {
            rentDao.update(rentWithRecurringOrder);
        });

    }

    @Test
    void shouldDeleteRent() {
        assertEquals(Integer.valueOf(1), rentDao.delete(EXISTING_RENT_ID));
        assertEquals(NUMBER_OF_RENTS_AFTER_DELETE, rentDao.findAll().size());
    }

    @Test
    void hasDressAlreadyBeenRentedForThisDate() {
        Rent newRent = new Rent();
        newRent.setDressId(NEW_RENT_DRESS_ID);
        newRent.setRentDate(NEW_RENT_DATE);

        Rent duplicatedRent = new Rent();
        duplicatedRent.setDressId(EXISTING_RENT_DRESS_ID);
        duplicatedRent.setRentDate(EXISTING_RENT_DATE);

        assertTrue(rentDao.hasDressAlreadyBeenRentedForThisDate(duplicatedRent));
        assertFalse(rentDao.hasDressAlreadyBeenRentedForThisDate(newRent));
    }
}