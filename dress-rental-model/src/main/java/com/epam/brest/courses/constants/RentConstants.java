package com.epam.brest.courses.constants;

/**
 * Contains the column names and limitations in the rent table..
 * @author Kirill Karpesh
 * @version 1.0
 * @since 1.0
 */
public final class RentConstants {

    /**
     * The column name for rent ID.
     */
    public static final String RENT_ID = "rentId";

    /**
     * The column name for client.
     */
    public static final String CLIENT = "client";

    /**
     * The column name for rent date.
     */
    public static final String RENT_DATE = "rentDate";

    /**
     * The column name for dress ID.
     */
    public static final String DRESS_ID = "dressId";

    /**
     * The limitation for the client.
     */
    public static final int RENT_CLIENT_SIZE = 50;

    /**
     * Private constructor.
     */
    private RentConstants() {
    }
}
