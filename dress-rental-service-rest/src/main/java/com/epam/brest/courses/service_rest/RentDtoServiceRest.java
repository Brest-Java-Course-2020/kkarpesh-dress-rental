package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.dto.RentDto;
import com.epam.brest.courses.service_api.dto.RentDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

/**
 * Gets rentDtos data from RESTful source in JSON format.
 */
public class RentDtoServiceRest implements RentDtoService {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DressDtoServiceRest.class);

    /**
     * The RESTful source URL.
     */
    private final String url;

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
    public RentDtoServiceRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    /**
     * Finds rents with dress name for a given period of time.
     *
     * @param dateFrom period start date.
     * @param dateTo   period finish date.
     * @return rents with dress name for a given period of time.
     */
    @Override
    public List<RentDto> findAllWIthDressNameByDate(LocalDate dateFrom,
                                                    LocalDate dateTo) {
        LOGGER.debug("Gets all dressDtos from REST");
        String fullUrl = url;

        if (dateFrom != null && dateTo == null) {
            fullUrl += "?dateFrom=" + dateFrom.toString();
        }
        if (dateFrom == null && dateTo != null) {
            fullUrl += "?dateTo=" + dateTo.toString();
        }
        if (dateFrom != null && dateTo != null) {
            fullUrl += "?dateFrom=" + dateFrom.toString()
                    + "&dateTo=" + dateTo.toString();
        }

        ResolvableType resolvableType =
                ResolvableType.forClassWithGenerics(List.class, RentDto.class);
        ParameterizedTypeReference<List<RentDto>> refType =
                ParameterizedTypeReference.forType(resolvableType.getType());
        ResponseEntity<List<RentDto>> responseEntity =
                restTemplate.exchange(fullUrl, HttpMethod.GET,
                        null, refType);
        return responseEntity.getBody();
    }
}
