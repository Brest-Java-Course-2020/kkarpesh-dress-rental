package com.epam.brest.courses.model;

import java.time.LocalDate;

public class RentedDress {

    private Integer rentedDressId;
    private String client;
    private LocalDate dateOfRent;

    public Integer getRentedDressId() {
        return rentedDressId;
    }

    public void setRentedDressId(Integer rentedDressId) {
        this.rentedDressId = rentedDressId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    @Override
    public String toString() {
        return "RentedDress{" +
                "rentedDressId=" + rentedDressId +
                ", client='" + client + '\'' +
                ", dateOfRent=" + dateOfRent +
                '}';
    }
}
