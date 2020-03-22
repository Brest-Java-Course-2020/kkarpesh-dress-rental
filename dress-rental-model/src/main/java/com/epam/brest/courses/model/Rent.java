package com.epam.brest.courses.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Rent {

    private Integer rentId;
    private String client;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentDate;

    private Integer dressId;

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public Integer getDressId() {
        return dressId;
    }

    public void setDressId(Integer dressId) {
        this.dressId = dressId;
    }

    @Override
    public String toString() {
        return "Rent{"
                + "rentId=" + rentId
                + ", client='" + client + '\''
                + ", rentDate=" + rentDate
                + ", dressId=" + dressId + '}';
    }
}
