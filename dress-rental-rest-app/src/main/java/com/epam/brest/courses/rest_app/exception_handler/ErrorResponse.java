package com.epam.brest.courses.rest_app.exception_handler;

import java.util.List;

/**
 * Class for human readable representation of response errors.
 */
public class ErrorResponse {

    /**
     * Short form of error.
     */
    private String message;

    /**
     * Detailed error description.
     */
    private List<String> details;

    /**
     * Constructs a new instance of the error response.
     *
     * @param message message.
     * @param details list of details.
     */
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    /**
     * Gets the message.
     *
     * @return the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the list of details.
     *
     * @return the list of details.
     */
    public List<String> getDetails() {
        return details;
    }

    /**
     * Sets the list of details.
     *
     * @param details details.
     */
    public void setDetails(List<String> details) {
        this.details = details;
    }
}
