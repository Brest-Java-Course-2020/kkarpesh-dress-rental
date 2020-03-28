package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service.DressServiceImpl;
import com.epam.brest.courses.service.dto.DressDtoServiceImpl;
import com.epam.brest.courses.web_app.validators.DressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Dress controller.
 */
@Controller
@RequestMapping("/dresses")
public class DressController {

    /**
     * Default logger for current class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DressController.class);

    /**
     * Service layer object to get information of dress.
     */
    @Autowired
    private DressDtoServiceImpl dressDtoService;

    /**
     * Service layer object to get information of dressDto.
     */
    @Autowired
    private DressServiceImpl dressService;

    /**
     * Object to validate dress.
     */
    @Autowired
    private DressValidator dressValidator;


    @GetMapping
    public final String getAll(Model model) {
        List<DressDto> dresses = dressDtoService.findAllWithNumberOfOrders();
        model.addAttribute("dresses", dresses);
        Dress dress = new Dress();
        model.addAttribute("dress", dress);
        return "dresses";
    }


    @PostMapping
    public final String createOrUpdate(@Valid Dress dress, BindingResult result) {
        LOGGER.debug("Create or update dress {}, {}", dress, result);

        dressValidator.validate(dress, result);
        if (result.hasErrors()) {
            return "redirect:/dresses";
        } else {
            if (dress.getDressId() == null) {
                dressService.create(dress);
            } else {
                dressService.update(dress);
            }
            return "redirect:/dresses";
        }

    }

    @GetMapping("/delete/{id}")
    public final String delete(@PathVariable Integer id) {
        dressService.delete(id);
        return "redirect:/dresses";
    }

}
