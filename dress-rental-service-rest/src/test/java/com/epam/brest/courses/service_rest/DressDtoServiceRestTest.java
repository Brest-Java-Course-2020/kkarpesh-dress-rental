package com.epam.brest.courses.service_rest;

import com.epam.brest.courses.model.dto.DressDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:app-context-test.xml")
class DressDtoServiceRestTest {

    public static final String DRESS_DTOS_URL = "http://localhost:8088/dress_dtos";

    @Autowired
    RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    private ObjectMapper mapper = new ObjectMapper();

    DressDtoServiceRest dressDtoService;

    @BeforeEach
    public void before() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
        dressDtoService = new DressDtoServiceRest(DRESS_DTOS_URL, restTemplate);
    }

    @Test
    void shouldFindAllWithNumberOfOrders() throws JsonProcessingException {
        // given
        mockServer.expect(ExpectedCount.once(), requestTo(DRESS_DTOS_URL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(new DressDto(), new DressDto())))
                );

        //when
        List<DressDto> dressDtos = dressDtoService.findAllWithNumberOfOrders();

        // then
        mockServer.verify();
        assertNotNull(dressDtos);
        assertTrue(dressDtos.size() > 0);
        assertEquals(DressDto.class, dressDtos.get(0).getClass());
    }
}