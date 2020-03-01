package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.DressDao;
import com.epam.brest.courses.model.Dress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {

    private DressDao dressDao;

    public DressService(DressDao dressDao) {
        this.dressDao = dressDao;
    }

    public List<Dress> getDresses(){
        return dressDao.getDresses();
    }

}
