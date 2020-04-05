package com.epam.brest.courses.web_app.exception_handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

/**
 * Class for handling errors.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * Handles http client error exception.
     *
     * @param ex HttpClientErrorException.
     * @param model model for storing information for rendering a view.
     * @return view name.
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public final String handleClientError(HttpClientErrorException ex,
                                          Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    /**
     * Handles http server error exception.
     *
     * @param ex HttpServerErrorException.
     * @param model model for storing information for rendering a view.
     * @return view name.
     */
    @ExceptionHandler(HttpServerErrorException.class)
    public final String handleServerError(HttpServerErrorException ex,
                                          Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    /**
     * Handles resource access exception.
     *
     * @param ex ResourceAccessException.
     * @param model model for storing information for rendering a view.
     * @return view name.
     */
    @ExceptionHandler(ResourceAccessException.class)
    public final String handleAccessError(ResourceAccessException ex,
                                          Model model) {
        model.addAttribute("message",
                "Oops, something went wrong. Please try again later.");
        return "error";
    }
}
