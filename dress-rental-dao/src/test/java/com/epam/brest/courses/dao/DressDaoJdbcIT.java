package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Dress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath*:dao.xml"})
@Transactional
class DressDaoJdbcIT {

    @Autowired
    private DressDao dressDao;

    private static final int NUMBER_OF_DRESSES = 5;
    private static final int NUMBER_OF_DRESS_AFTER_CREATE = 6;
    private static final int NUMBER_OF_DRESS_AFTER_DELETE = 4;

    private static final String NEW_DRESS_NAME = "New dress";
    private static final int NONEXISTENT_DRESS_ID = 6;

    private static final String EXISTING_DRESS_NAME = "Ruffled printed dress";
    private static final int EXISTING_DRESS_ID_WITH_RENTS = 2;

    private static final int DRESS_ID_WITHOUT_RENTS = 3;

    private static final int DRESS_ID_WITH_ORDERS = 1;
    private static final int DRESS_ID_WITHOUT_ORDERS = 3;


    @Test
    void shouldFindAllDresses() {
        List<Dress> dresses = dressDao.findAll();

        assertNotNull(dresses);
        assertEquals(NUMBER_OF_DRESSES, dresses.size());
    }

    @Test
    void shouldFindDressWithExistingId() {
        Optional<Dress> dress = dressDao.findById(EXISTING_DRESS_ID_WITH_RENTS);

        assertTrue(dress.isPresent());
        assertEquals(EXISTING_DRESS_NAME, dress.get().getDressName());
    }

    @Test
    void shouldReturnNullWhenFindByNonexistentId() {
        Optional<Dress> dress = dressDao.findById(NONEXISTENT_DRESS_ID);

        assertTrue(dress.isEmpty());
    }

    @Test
    void shouldCreateNewDress() {
        Dress newDress = new Dress();
        newDress.setDressName(NEW_DRESS_NAME);

        Integer newDressId = dressDao.create(newDress);

        assertNotNull(newDressId);
        assertEquals(NUMBER_OF_DRESS_AFTER_CREATE, dressDao.findAll().size());

        Optional<Dress> createdDress = dressDao.findById(newDressId);

        assertTrue(createdDress.isPresent());
        assertEquals(NEW_DRESS_NAME, createdDress.get().getDressName());
    }

    @Test
    void shouldThrowExceptionWhenCreateNewDressWithExistingName() {
        Dress newDressWithExistingName = new Dress();
        newDressWithExistingName.setDressName(EXISTING_DRESS_NAME);

        assertThrows(IllegalArgumentException.class, () -> {
            dressDao.create(newDressWithExistingName);
        });
    }

    @Test
    void shouldUpdatedDress() {
        Dress dress = new Dress();
        dress.setDressId(EXISTING_DRESS_ID_WITH_RENTS);
        dress.setDressName(NEW_DRESS_NAME);

        assertEquals(Integer.valueOf(1), dressDao.update(dress));
        assertEquals(NUMBER_OF_DRESSES, dressDao.findAll().size());

        Optional<Dress> updatedDress = dressDao.findById(EXISTING_DRESS_ID_WITH_RENTS);

        assertTrue(updatedDress.isPresent());
        assertEquals(NEW_DRESS_NAME, updatedDress.get().getDressName());
    }

    @Test
    void shouldThrowExceptionWhenUpdateDressWithExistingName() {
        Dress dressWithExistingName = new Dress();
        dressWithExistingName.setDressId(DRESS_ID_WITHOUT_RENTS);
        dressWithExistingName.setDressName(EXISTING_DRESS_NAME);

        assertThrows(IllegalArgumentException.class, () -> {
            dressDao.update(dressWithExistingName);
        });
    }

    @Test
    void shouldDoNothingWhenUpdateDressWithNonexistentId() {
        Dress dressWithNonexistentId = new Dress();
        dressWithNonexistentId.setDressId(NONEXISTENT_DRESS_ID);
        dressWithNonexistentId.setDressName(NEW_DRESS_NAME);

        dressDao.update(dressWithNonexistentId);

        assertEquals(NUMBER_OF_DRESSES, dressDao.findAll().size());
    }

    @Test
    void shouldDeleteDressThatDoesNotHaveRents() {
        assertEquals(Integer.valueOf(1), dressDao.delete(DRESS_ID_WITHOUT_RENTS));
        assertEquals(NUMBER_OF_DRESS_AFTER_DELETE, dressDao.findAll().size());
    }

    @Test
    void shouldThrowExceptionWhenDeleteDressWithRents() {
        assertThrows(UnsupportedOperationException.class, () -> {
            dressDao.delete(EXISTING_DRESS_ID_WITH_RENTS);
        });
    }

    @Test
    void isNameUnique() {

        assertTrue(dressDao.isNameAlreadyExist(EXISTING_DRESS_NAME));

        assertFalse(dressDao.isNameAlreadyExist(NEW_DRESS_NAME));
    }

    @Test
    void isDressHasRents() {

        assertTrue(dressDao.isDressHasRents(DRESS_ID_WITH_ORDERS));

        assertFalse(dressDao.isDressHasRents(DRESS_ID_WITHOUT_ORDERS));
    }
}