package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.dto.RentDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:app-context-test.xml")
class RentDtoServiceRestTest {

    private static final String RENT_DTOS_URL = "http://localhost:8088/rents";

    @Autowired
    RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    private ObjectMapper mapper =
            new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    RentDtoServiceRest rentDtoService;

    @BeforeEach
    public void before() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
        rentDtoService = new RentDtoServiceRest(RENT_DTOS_URL, restTemplate);
    }

    @Test
    void shouldFindAllWIthDressNameByDateIfDateFromAndDateToAreNull() throws JsonProcessingException {
        // given
        LocalDate dateFrom = null;
        LocalDate dateTo = null;
        mockServer.expect(ExpectedCount.once(), requestTo(RENT_DTOS_URL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(new RentDto(), new RentDto())))
                );

        // when
        List<RentDto> rents = rentDtoService.findAllWIthDressNameByDate(dateFrom, dateTo);

        // then
        mockServer.verify();
        assertNotNull(rents);
        assertTrue(rents.size() > 0);
        assertEquals(RentDto.class, rents.get(0).getClass());
    }

    @Test
    void shouldFindAllWIthDressNameByDateIfDateFromIsNull() throws JsonProcessingException {
        // given
        LocalDate dateFrom = null;
        LocalDate dateTo = LocalDate.now();
        mockServer.expect(ExpectedCount.once(), requestTo(RENT_DTOS_URL + "?dateTo=" + dateTo.toString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(new RentDto(), new RentDto())))
                );

        // when
        List<RentDto> rents = rentDtoService.findAllWIthDressNameByDate(dateFrom, dateTo);

        // then
        mockServer.verify();
        assertNotNull(rents);
        assertTrue(rents.size() > 0);
        assertEquals(RentDto.class, rents.get(0).getClass());
    }

    @Test
    void shouldFindAllWIthDressNameByDateIfDateToIsNull() throws JsonProcessingException {
        // given
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = null;
        mockServer.expect(ExpectedCount.once(), requestTo(RENT_DTOS_URL + "?dateFrom=" + dateFrom.toString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(new RentDto(), new RentDto())))
                );

        // when
        List<RentDto> rents = rentDtoService.findAllWIthDressNameByDate(dateFrom, dateTo);

        // then
        mockServer.verify();
        assertNotNull(rents);
        assertTrue(rents.size() > 0);
        assertEquals(RentDto.class, rents.get(0).getClass());
    }

    @Test
    void shouldFindAllWIthDressNameByDate() throws JsonProcessingException {
        // given
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = LocalDate.now();
        mockServer.expect(ExpectedCount.once(), requestTo(RENT_DTOS_URL + "?dateFrom=" + dateFrom.toString() + "&dateTo=" + dateTo.toString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(new RentDto(), new RentDto())))
                );

        // when
        List<RentDto> rents = rentDtoService.findAllWIthDressNameByDate(dateFrom, dateTo);

        // then
        mockServer.verify();
        assertNotNull(rents);
        assertTrue(rents.size() > 0);
        assertEquals(RentDto.class, rents.get(0).getClass());
    }
}