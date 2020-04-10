package com.epam.brest.courses.rest_app.exception_handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

/**
 * Class for handling REST errors.
 */
@ControllerAdvice
public class ExceptionRestControllerAdviser
        extends ResponseEntityExceptionHandler {

    /**
     * Short form of validation error.
     */
    private static final String VALIDATION_ERROR =
            "validation_error";

    /**
     * Short form of prohibited action error.
     */
    private static final String PROHIBITED_ACTION_ERROR =
            "prohibited_action";

    /**
     * Short form of data integrity violation error.
     */
    private static final String DATA_INTEGRITY_VIOLATION =
            "data_integrity_violation";


    /**
     * Handles illegal argument exception.
     *
     * @param ex IllegalArgumentException.
     * @return the response entity with message of exception
     * and http status code.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ErrorResponse>
    handleIllegalArgumentException(IllegalArgumentException ex) {

        return new ResponseEntity<>(
                new ErrorResponse(VALIDATION_ERROR,
                        Collections.singletonList(ex.getMessage())),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Handles unsupported operation exception.
     *
     * @param ex UnsupportedOperationException.
     * @return the response entity with message of exception
     * and http status code.
     */
    @ExceptionHandler(UnsupportedOperationException.class)
    public final ResponseEntity<ErrorResponse>
    handleUnsupportedOperationException(UnsupportedOperationException ex) {

        return new ResponseEntity<>(
                new ErrorResponse(PROHIBITED_ACTION_ERROR,
                        Collections.singletonList(ex.getMessage())),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles data integrity violation exception.
     *
     * @param ex DataIntegrityViolationException.
     * @return the response entity with message of exception
     * and http status code.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ErrorResponse>
    handleDataIntegrityViolationException(
            DataIntegrityViolationException ex) {

        return new ResponseEntity<>(
                new ErrorResponse(DATA_INTEGRITY_VIOLATION,
                        Collections.singletonList(
                                "Data integrity violation error")),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
