package com.epam.brest.courses.model.dto;

/**
 * DTO class of dress.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public class DressDto {

    /**
     * The dress ID.
     */
    private Integer dressId;

    /**
     * The dress name.
     */
    private String dressName;

    /**
     * The number of orders.
     */
    private Integer numberOfOrders;

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
     * Gets the number of orders.
     *
     * @return the number of orders.
     */
    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    /**
     * Sets the number of orders.
     *
     * @param numberOfOrders A Integer containing the number of orders.
     */
    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    /**
     * Outputs this DTO class of dress as a String.
     *
     * @return a string representation of this DTO class of dress.
     */
    @Override
    public String toString() {
        return "DressDto{"
                + "dressId=" + dressId
                + ", dressName='" + dressName + '\''
                + ", numberOfOrders=" + numberOfOrders + '}';
    }
}
