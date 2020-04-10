package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.DressDao;
import com.epam.brest.courses.model.Dress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DressServiceImplMockTest {

    @Mock
    private DressDao dressDao;

    @InjectMocks
    private DressServiceImpl dressService;

    @Test
    void shouldFindAllDress() {
        when(dressDao.findAll()).thenReturn(Collections.singletonList(new Dress()));

        List<Dress> dresses = dressService.findAll();
        assertNotNull(dresses);
        assertTrue(dresses.size() > 0);

        verify(dressDao, times(1)).findAll();
    }

    @Test
    void shouldFindDressWithExistingId() {
        Integer dressId = 1;
        String dressName = "Dress";
        Dress dress = new Dress();
        dress.setDressId(dressId);
        dress.setDressName(dressName);

        when(dressDao.findById(anyInt())).thenReturn(Optional.of(dress));

        Optional<Dress> optionalDress = dressService.findById(dressId);
        assertTrue(optionalDress.isPresent());
        assertSame(dress, optionalDress.get());

        verify(dressDao, times(1)).findById(dressId);
    }

    @Test
    void shouldReturnNullWhenFindByNonexistentId() {
        when(dressDao.findById(anyInt())).thenReturn(Optional.empty());

        Optional<Dress> optionalDress = dressService.findById(anyInt());
        assertTrue(optionalDress.isEmpty());

        verify(dressDao, times(1)).findById(anyInt());
    }

    @Test
    void shouldCreateNewDress() {
        Integer dressId = 1;
        when(dressDao.create(any())).thenReturn(dressId);

        Integer id = dressService.create(any());

        assertNotNull(id);
        assertEquals(dressId, id);

        verify(dressDao, times(1)).create(any());
    }

    @Test
    void shouldThrowExceptionWhenCreateNewDressWithExistingName() {
        when(dressDao.create(any())).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            dressService.create(any());
        });

        verify(dressDao, times(1)).create(any());
    }

    @Test
    void shouldUpdatedDress() {
        when(dressDao.update(any())).thenReturn(1);

        Integer result = dressService.update(any());

        assertNotNull(result);
        assertEquals(1, (int) result);

        verify(dressDao, times(1)).update(any());
    }

    @Test
    void shouldThrowExceptionWhenUpdateDressWithExistingName() {
        when(dressDao.update(any())).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            dressService.update(any());
        });

        verify(dressDao, times(1)).update(any());
    }

    @Test
    void shouldDeleteDressThatDoesNotHaveRents() {
        when(dressDao.delete(anyInt())).thenReturn(1);

        Integer result = dressService.delete(anyInt());

        assertNotNull(result);
        assertEquals(1, (int) result);

        verify(dressDao, times(1)).delete(anyInt());
    }

    @Test
    void shouldThrowExceptionWhenDeleteDressWithRents() {
        when(dressDao.delete(anyInt())).thenThrow(UnsupportedOperationException.class);

        assertThrows(UnsupportedOperationException.class, () -> {
            dressService.delete(anyInt());
        });

        verify(dressDao, times(1)).delete(anyInt());
    }

    @Test
    void isNameAlreadyExistReturnTrue() {
        when(dressDao.isNameAlreadyExist(any())).thenReturn(true);

        assertTrue(dressService.isNameAlreadyExist(any()));

        verify(dressDao, times(1)).isNameAlreadyExist(any());
    }

    @Test
    void isNameAlreadyExistReturnFalse() {
        when(dressDao.isNameAlreadyExist(any())).thenReturn(false);

        assertFalse(dressService.isNameAlreadyExist(any()));

        verify(dressDao, times(1)).isNameAlreadyExist(any());
    }

    @Test
    void isDressHasRentsReturnTrue() {
        when(dressDao.isDressHasRents(anyInt())).thenReturn(true);

        assertTrue(dressService.isDressHasRents(anyInt()));

        verify(dressDao, times(1)).isDressHasRents(anyInt());
    }

    @Test
    void isDressHasRentsReturnFalse() {
        when(dressDao.isDressHasRents(anyInt())).thenReturn(false);

        assertFalse(dressService.isDressHasRents(anyInt()));

        verify(dressDao, times(1)).isDressHasRents(anyInt());
    }
}