package com.epam.brest.courses.model;

public class Dress {

    private Integer dressId;
    private String dressName;

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

    @Override
    public String toString() {
        return "Dress{" +
                "dressId=" + dressId +
                ", dressName='" + dressName + '\'' +
                '}';
    }
}
