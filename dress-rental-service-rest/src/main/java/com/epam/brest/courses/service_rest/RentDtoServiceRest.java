package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.dto.RentDto;
import com.epam.brest.courses.service_api.dto.RentDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        String fullUrl = "";

        if (dateFrom == null && dateTo == null) {
            fullUrl = url;
        }
        if (dateFrom != null && dateTo == null) {
            fullUrl = url + "?dateFrom=" + dateFrom.toString();
        }
        if (dateFrom == null && dateTo != null) {
            fullUrl = url + "?dateTo=" + dateTo.toString();
        }
        if (dateFrom != null && dateTo != null) {
            fullUrl = url + "?dateFrom=" + dateFrom.toString() + "&dateTo=" + dateTo.toString();
        }

        ResponseEntity responseEntity =
                restTemplate.getForEntity(fullUrl, List.class);
        return (List<RentDto>) responseEntity.getBody();
    }
}
