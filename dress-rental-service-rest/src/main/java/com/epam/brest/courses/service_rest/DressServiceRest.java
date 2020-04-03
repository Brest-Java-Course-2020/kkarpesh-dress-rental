package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.service_api.DressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Gets dresses data from RESTful source in JSON format.
 */
public class DressServiceRest implements DressService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DressServiceRest.class);

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
    public DressServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    /**
     * Gets all dresses from source.
     *
     * @return dresses list.
     */
    @Override
    public List<Dress> findAll() {
        LOGGER.debug("Gets all dresses from REST");
        ResponseEntity responseEntity =
                restTemplate.getForEntity(url, List.class);
        return (List<Dress>) responseEntity.getBody();
    }

    /**
     * Gets dress by given ID from source.
     *
     * @param dressId dress Id.
     * @return a Optional description of the dress found.
     */
    @Override
    public Optional<Dress> findById(Integer dressId) {
        LOGGER.debug("Find dress by ID {}", dressId);
        ResponseEntity<Dress> responseEntity =
                restTemplate.getForEntity(url + "/" + dressId, Dress.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    /**
     * Creates new dress.
     *
     * @param dress dress.
     * @return created dress ID.
     */
    @Override
    public Integer create(Dress dress) {
        LOGGER.debug("Create new dress {}", dress);
        ResponseEntity<Integer> responseEntity =
                restTemplate.postForEntity(url, dress, Integer.class);
        return responseEntity.getBody();
    }

    /**
     * Updates an existing dress with a new object.
     *
     * @param dress dress.
     * @return number of updated records in the database.
     */
    @Override
    public Integer update(Dress dress) {
        LOGGER.debug("Update dress {}", dress);
        restTemplate.put(url, dress);
        return 1;
    }

    /**
     * Deletes dress from data source.
     *
     * @param dressId dress.
     * @return number of deleted records in the database.
     */
    @Override
    public Integer delete(Integer dressId) {
        LOGGER.debug("Delete dress with id = ", dressId);
        restTemplate.delete(url + "/" + dressId);
        return 1;
    }

    @Override
    public boolean isNameAlreadyExist(String dressName) {
        return false;
    }

    @Override
    public boolean isDressHasRents(Integer dressId) {
        return false;
    }
}
