package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.RentedDress;

import java.util.Date;
import java.util.List;

public interface RentedDressDao {

    List<RentedDress> getRentedDresses();

    RentedDress getRentedDressById(Integer rentedDressId);

    List <RentedDress> getRentedDressesByDate(Date dateFrom, Date dateTo);

    RentedDress addRentedDress(RentedDress rentedDress);

    void updateRentedDress(RentedDress rentedDress);

    void deleteRentedDress(Integer rentedDressId);

}
