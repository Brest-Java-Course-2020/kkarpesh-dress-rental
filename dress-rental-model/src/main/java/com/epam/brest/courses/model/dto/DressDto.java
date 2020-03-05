package com.epam.brest.courses.model.dto;

public class DressDto {

    private Integer dressId;

    private String dressName;

    private Integer numberOfOrders;

    public Integer getDressId() {
        return dressId;
    }

    public void setDressId(Integer dressId) {
        this.dressId = dressId;
    }

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    @Override
    public String toString() {
        return "DressDto{" +
                "dressId=" + dressId +
                ", dressName='" + dressName + '\'' +
                ", numberOfOrders=" + numberOfOrders +
                '}';
    }
}
