package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service_api.dto.DressDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Gets dressDtos data from RESTful source in JSON format.
 */
public class DressDtoServiceRest implements DressDtoService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DressDtoServiceRest.class);

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
    public DressDtoServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    /**
     * Gets all dressDtos from source.
     *
     * @return dressDtos list.
     */
    @Override
    public List<DressDto> findAllWithNumberOfOrders() {
        LOGGER.debug("Gets all dressDtos from REST");
        ResolvableType resolvableType =
                ResolvableType.forClassWithGenerics(List.class, DressDto.class);
        ParameterizedTypeReference<List<DressDto>> refType =
                ParameterizedTypeReference.forType(resolvableType.getType());
        ResponseEntity<List<DressDto>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        refType);
        return responseEntity.getBody();
    }
}
