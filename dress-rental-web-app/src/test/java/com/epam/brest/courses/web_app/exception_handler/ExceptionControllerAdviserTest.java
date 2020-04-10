package com.epam.brest.courses.web_app.exception_handler;

import com.epam.brest.courses.service_api.DressService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:app-context-test.xml")
class ExceptionControllerAdviserTest {

    private MockMvc mockMvc;
    private static final String DRESSES_ENDPOINT = "/dresses";

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private DressService dressService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @AfterEach
    void after() {
        Mockito.reset(dressService);
    }

    @Test
    void handleClientError() throws Exception {
        Mockito.when(dressService.findById(1)).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        mockMvc.perform(get(DRESSES_ENDPOINT + "/" + 1)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("error"))
                .andExpect(model().attributeExists("message"));

    }

    @Test
    void handleServerError() throws Exception {
        Mockito.when(dressService.findById(1)).thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

        mockMvc.perform(get(DRESSES_ENDPOINT + "/" + 1)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("error"))
                .andExpect(model().attributeExists("message"));

    }

    @Test
    void handleAccessError() throws Exception {
        Mockito.when(dressService.findById(1)).thenThrow(new ResourceAccessException("Error"));

        mockMvc.perform(get(DRESSES_ENDPOINT + "/" + 1)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("error"))
                .andExpect(model().attributeExists("message"));

    }
}