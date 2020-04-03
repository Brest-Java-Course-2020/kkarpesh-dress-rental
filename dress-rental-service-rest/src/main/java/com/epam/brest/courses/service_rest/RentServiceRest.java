package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.Rent;
import com.epam.brest.courses.service_api.RentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public class RentServiceRest implements RentService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(RentServiceRest.class);

    /**
     * The RESTful source URL.
     */
    private String url;

    /**
     * Synchronous client to perform HTTP request.
     */
    private RestTemplate restTemplate;

    /**
     * Constructs new object with given url and Rest Template object.
     *
     * @param url          url.
     * @param restTemplate res template.
     */
    public RentServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Rent> findAll() {
        LOGGER.debug("Gets all dresses from REST");
        ResponseEntity responseEntity =
                restTemplate.getForEntity(url, List.class);
        return (List<Rent>) responseEntity.getBody();
    }

    @Override
    public Optional<Rent> findById(Integer rentId) {
        return Optional.empty();
    }

    @Override
    public Integer create(Rent rent) {
        return null;
    }

    @Override
    public Integer update(Rent rent) {
        return null;
    }

    @Override
    public Integer delete(Integer rentId) {
        return null;
    }

    @Override
    public Boolean hasDressAlreadyBeenRentedForThisDate(Rent rent) {
        return false;
    }
}
