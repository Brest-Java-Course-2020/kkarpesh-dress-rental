package com.epam.brest.courses.model;

/**
 * Represents a dress model from the database.
 *
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public class Dress {

    /**
     * The dress ID.
     */
    private Integer dressId;

    /**
     * The dress name.
     */
    private String dressName;

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
     * Outputs this dress as a String.
     *
     * @return a string representation of this dress.
     */
    @Override
    public String toString() {
        return "Dress{"
                + "dressId=" + dressId
                + ", dressName='" + dressName + '\'' + '}';
    }
}
