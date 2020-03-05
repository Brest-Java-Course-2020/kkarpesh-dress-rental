package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Rent;

import java.util.Date;
import java.util.List;

public interface RentedDressDao {

    List<Rent> getRentedDresses();

    Rent getRentedDressById(Integer rentedDressId);

    List <Rent> getRentedDressesByDate(Date dateFrom, Date dateTo);

    Rent addRentedDress(Rent rent);

    void updateRentedDress(Rent rent);

    void deleteRentedDress(Integer rentedDressId);

}
