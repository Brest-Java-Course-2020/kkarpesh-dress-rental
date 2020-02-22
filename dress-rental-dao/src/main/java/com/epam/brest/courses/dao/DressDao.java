package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Dress;

import java.util.List;

public interface DressDao {

    List <Dress> getDresses();

    Dress getDressById(Integer dressId);

    Dress addDress(Dress dress);

    void updateDress(Dress dress);

    void deleteDress(Integer dressId);
}
