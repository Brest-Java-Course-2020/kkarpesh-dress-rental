package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service_api.DressService;
import com.epam.brest.courses.service_api.dto.DressDtoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:app-context-test.xml")
class DressControllerMockTest {

    private MockMvc mockMvc;
    private static final String DRESSES_ENDPOINT = "/dresses";

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private DressService dressService;

    @Autowired
    private DressDtoService dressDtoService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    void shouldReturnDressPage() throws Exception {
        DressDto dress1 = new DressDto();
        dress1.setDressId(1);
        dress1.setDressName("Dress 1");
        dress1.setNumberOfOrders(2);
        DressDto dress2 = new DressDto();
        dress2.setDressId(2);
        dress2.setDressName("Dress 2");
        dress2.setNumberOfOrders(0);
        List<DressDto> dresses = Arrays.asList(dress1, dress2);
        Mockito.when(dressDtoService.findAllWithNumberOfOrders()).thenReturn(dresses);

        mockMvc.perform(get(DRESSES_ENDPOINT)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("dresses"))
                .andExpect(model().attribute("dresses", hasItem(
                        allOf(
                                hasProperty("dressId", is(dress1.getDressId())),
                                hasProperty("dressName", is(dress1.getDressName())),
                                hasProperty("numberOfOrders", is(dress1.getNumberOfOrders()))
                        )
                )))
                .andExpect(model().attribute("dresses", hasItem(
                        allOf(
                                hasProperty("dressId", is(dress2.getDressId())),
                                hasProperty("dressName", is(dress2.getDressName())),
                                hasProperty("numberOfOrders", is(dress2.getNumberOfOrders()))
                        )
                )));

        Mockito.verify(dressDtoService, Mockito.times(1)).findAllWithNumberOfOrders();
    }

    @Test
    void shouldGotoAddDressPage() throws Exception {
        Dress dress = new Dress();

        mockMvc.perform(get(DRESSES_ENDPOINT + "/new")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("dress"))
                .andExpect(model().attribute("isNew", true))
                .andExpect(model().attribute("dress", isA(Dress.class)));
    }

    @Test
    void shouldGotoEditDressPage() throws Exception {
        Dress dress = new Dress();
        Integer id = 1;
        dress.setDressId(id);
        dress.setDressName("Dress 1");
        Mockito.when(dressService.findById(id)).thenReturn(Optional.of(dress));

        mockMvc.perform(get(DRESSES_ENDPOINT + "/" + id)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("dress"))
                .andExpect(model().attribute("dress", hasProperty("dressId", is(dress.getDressId()))))
                .andExpect(model().attribute("dress", hasProperty("dressName", is(dress.getDressName()))));

        Mockito.verify(dressService, Mockito.times(1)).findById(id);
    }

    @Test
    void shouldRedirectToDressPageIfDressMotFoundById() throws Exception {
        Integer id = 999;
        Mockito.when(dressService.findById(id)).thenReturn(Optional.empty());

        mockMvc.perform(get(DRESSES_ENDPOINT + "/" + id)).andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/dresses"));

        Mockito.verify(dressService, Mockito.times(1)).findById(id);
    }

    @Test
    void shouldUpdateDressAfterEdit() throws Exception {
        Dress dress = new Dress();
        dress.setDressId(1);
        dress.setDressName("Dress 1");
        Mockito.when(dressService.update(dress)).thenReturn(1);

        mockMvc.perform(post(DRESSES_ENDPOINT)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("dressId", dress.getDressId().toString())
                .param("dressName", dress.getDressName())
                .sessionAttr("dress", dress)
        ).andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/dresses"));

    }


}