package com.epam.brest.courses.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RentDto {

    private Integer rentId;

    private String client;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date rentDate;

    private String dressName;

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

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
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
