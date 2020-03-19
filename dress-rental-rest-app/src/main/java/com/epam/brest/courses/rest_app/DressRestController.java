package com.epam.brest.courses.rest_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.rest_app.exception.DressNotFoundException;
import com.epam.brest.courses.service_api.DressService;
import com.epam.brest.courses.service_api.dto.DressDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dresses")
public class DressRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DressRestController.class);

    @Autowired
    private DressService dressService;

    @Autowired
    private DressDtoService dressDtoService;

    @GetMapping("/{id}")
    public Dress findById(@PathVariable Integer id) {
        LOGGER.debug("Find dress by id = {}", id);
        return dressService.findById(id).orElseThrow(() -> new DressNotFoundException(id));
    }

    @GetMapping
    public List<DressDto> findAllwithNumberOfOrders(){
        LOGGER.debug("Find all dresses with number of orders");
        return dressDtoService.findAllWithNumberOfOrders();
    }
}
