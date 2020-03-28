package com.epam.brest.courses.web_app.consumers;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.service_api.DressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Gets dresses data from RESTful source in JSON format.
 */
public class DressRestConsumer implements DressService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DressRestConsumer.class);

    /**
     * The RESTful source URL.
     */
    private String url;

    /**
     * Synchronous client to perform HTTP request.
     */
    private RestTemplate restTemplate;

    /**
     * Gets all dresses from source.
     *
     * @return dresses list.
     */
    @Override
    public List<Dress> findAll() {
        LOGGER.debug("Gets all dresses");
        ResponseEntity<List<Dress>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Dress>>() {
                        });

        return responseEntity.getBody();
    }

    @Override
    public Optional<Dress> findById(Integer dressId) {
        return Optional.empty();
    }

    @Override
    public Integer create(Dress dress) {
        return null;
    }

    @Override
    public Integer update(Dress dress) {
        return null;
    }

    @Override
    public Integer delete(Integer dressId) {
        return null;
    }
}
