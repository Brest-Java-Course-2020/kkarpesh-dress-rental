package com.epam.brest.courses.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO class of rent.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public class RentDto {

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate rentDate;

    /**
     * The dress name.
     */
    private String dressName;

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
     * Gets the dress name.
     *
     * @return the dress name.
     */
    public String getDressName() {
        return dressName;
    }

    /**
     * Sets the dress name.
     *
     * @param dressName A String containing the dress name.
     */
    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    /**
     * Outputs this DTO class of rent as a String.
     *
     * @return a string representation of this DTO class of rent.
     */
    @Override
    public String toString() {
        return "RentDto{"
                + "rentId=" + rentId
                + ", client='" + client + '\''
                + ", rentDate=" + rentDate
                + ", dressName='" + dressName + '\'' + '}';
    }
}
