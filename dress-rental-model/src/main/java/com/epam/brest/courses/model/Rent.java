package com.epam.brest.courses.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Represents a rent model from the database.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public class Rent {

    /**
     * The rent ID.
     */
    private Integer rentId;

    /**
     * The client.
     */
    private String client;

    /**
     * The rent date.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentDate;

    /**
     * The dress ID.
     */
    private Integer dressId;

    /**
     * Gets the rent ID.
     *
     * @return the rent ID.
     */
    public Integer getRentId() {
        return rentId;
    }

    /**
     * Sets the rent ID.
     *
     * @param rentId A Integer containing the rent ID.
     */
    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    /**
     * Gets the client.
     *
     * @return the client.
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the client.
     *
     * @param client A String containing the client.
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets the rent date.
     *
     * @return the rent date.
     */
    public LocalDate getRentDate() {
        return rentDate;
    }

    /**
     * Sets the rent date.
     *
     * @param rentDate A LocalDate containing the rent date.
     */
    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    /**
     * Gets the dress ID.
     *
     * @return the dress ID.
     */
    public Integer getDressId() {
        return dressId;
    }

    /**
     * Sets the dress ID.
     *
     * @param dressId A Integer containing the dress ID.
     */
    public void setDressId(Integer dressId) {
        this.dressId = dressId;
    }

    /**
     * Outputs this rent as a String.
     *
     * @return a string representation of this rent.
     */
    @Override
    public String toString() {
        return "Rent{"
                + "rentId=" + rentId
                + ", client='" + client + '\''
                + ", rentDate=" + rentDate
                + ", dressId=" + dressId + '}';
    }
}
