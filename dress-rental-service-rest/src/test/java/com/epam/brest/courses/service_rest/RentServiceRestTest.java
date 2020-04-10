package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.Rent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.RandomStringUtils;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.epam.brest.courses.constants.RentConstants.RENT_CLIENT_SIZE;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:app-context-test.xml")
class RentServiceRestTest {

    private static final String RENTS_URL = "http://localhost:8088/rents";

    @Autowired
    RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    private ObjectMapper mapper =
            new ObjectMapper().registerModule(new JavaTimeModule());

    RentServiceRest rentService;

    @BeforeEach
    public void before() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
        rentService = new RentServiceRest(RENTS_URL, restTemplate);
    }

    @Test
    void shouldFindAllRents() throws JsonProcessingException {
        // given
        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(new Rent(), new Rent())))
                );

        // when
        List<Rent> rents = rentService.findAll();

        // then
        mockServer.verify();
        assertNotNull(rents);
        assertTrue(rents.size() > 0);
        assertEquals(Rent.class, rents.get(0).getClass());
    }

    @Test
    void shouldFindRentById() throws JsonProcessingException {
        // given
        Integer id = 1;
        Rent rent = new Rent();
        rent.setRentId(id);
        rent.setClient(RandomStringUtils.randomAlphabetic(RENT_CLIENT_SIZE));
        rent.setDressId(id);
        rent.setRentDate(LocalDate.now());

        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL + "/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(rent))
                );

        // when
        Optional<Rent> optionalRent = rentService.findById(id);

        // then
        mockServer.verify();
        assertTrue(optionalRent.isPresent());
        assertEquals(rent.getRentId(), optionalRent.get().getRentId());
        assertEquals(rent.getClient(), optionalRent.get().getClient());
        assertEquals(rent.getRentDate(), optionalRent.get().getRentDate());
        assertEquals(rent.getDressId(), optionalRent.get().getDressId());
    }

    @Test
    void shouldCreateNewRent() throws JsonProcessingException {
        // given
        Rent rent = new Rent();
        rent.setClient(RandomStringUtils.randomAlphabetic(RENT_CLIENT_SIZE));
        rent.setDressId((int) (Math.random() * 100));
        rent.setRentDate(LocalDate.now());

        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString("1"))
                );

        // when
        Integer id = rentService.create(rent);

        // then
        mockServer.verify();
        assertNotNull(id);
    }

    @Test
    void shouldUpdateDress() throws JsonProcessingException {
        // given
        Integer id = 1;
        Rent rent = new Rent();
        rent.setRentId(id);
        rent.setClient(RandomStringUtils.randomAlphabetic(RENT_CLIENT_SIZE));
        rent.setRentDate(LocalDate.now());
        rent.setDressId((int) (Math.random() * 100));

        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL))
                .andExpect(method(HttpMethod.PUT))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString("1"))
                );

        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL + "/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(rent))
                );

        Integer result = rentService.update(rent);
        Optional<Rent> updatedRent = rentService.findById(id);

        // then
        mockServer.verify();
        assertEquals(1, (int) result);
        assertTrue(updatedRent.isPresent());
        assertEquals(rent.getDressId(), updatedRent.get().getDressId());
        assertEquals(rent.getClient(), updatedRent.get().getClient());
        assertEquals(rent.getRentDate(), updatedRent.get().getRentDate());
        assertEquals(rent.getDressId(), updatedRent.get().getDressId());
    }

    @Test
    void shouldDeleteDress() throws JsonProcessingException {
        // given
        Integer id = 1;
        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL + "/" + id))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString("1"))
                );

        // when
        Integer result = rentService.delete(id);

        // then
        mockServer.verify();
        assertEquals(1, (int) result);
    }

    @Test
    void shouldCheckHasDressAlreadyBeenRentedForThisDate() throws JsonProcessingException {
        //given
        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL + "/isExists"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(true))
                );

        // when
        Boolean result = rentService.hasDressAlreadyBeenRentedForThisDate(new Rent());

        // then
        mockServer.verify();
        assertTrue(result);
    }

    @Test
    void shouldCheckHasNotDressBeenRentedForThisDate() throws JsonProcessingException {
        //given
        mockServer.expect(ExpectedCount.once(), requestTo(RENTS_URL + "/isExists"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(false))
                );

        // when
        Boolean result = rentService.hasDressAlreadyBeenRentedForThisDate(new Rent());

        // then
        mockServer.verify();
        assertFalse(result);
    }

}