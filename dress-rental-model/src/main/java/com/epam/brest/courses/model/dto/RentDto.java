package com.epam.brest.courses.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class RentDto {

    private Integer rentId;

    private String client;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate rentDate;

    private String dressName;

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

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    public Integer getDressId() {
        return dressId;
    }

    public void setDressId(Integer dressId) {
        this.dressId = dressId;
    }

    @Override
    public String toString() {
        return "RentDto{"
                + "rentId=" + rentId
                + ", client='" + client + '\''
                + ", rentDate=" + rentDate
                + ", dressName='" + dressName + '\'' + '}';
    }
}
