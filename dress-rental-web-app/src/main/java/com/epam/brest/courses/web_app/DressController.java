package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service.DressServiceImpl;
import com.epam.brest.courses.service.dto.DressDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dresses")
public class DressController {

    @Autowired
    private DressDtoServiceImpl dressDtoService;

    @Autowired
    private DressServiceImpl dressService;

    @GetMapping
    public final String getAll(Model model) {
        List<DressDto> dresses = dressDtoService.findAllWithNumberOfOrders();
        model.addAttribute("dresses", dresses);
        Dress dress = new Dress();
        model.addAttribute("dress", dress);
        return "dresses";
    }

    @PostMapping
    public final String createOrUpdate(Dress dress) {
        if (dress.getDressId() == null) {
            dressService.create(dress);
        } else {
            dressService.update(dress);
        }
        return "redirect:/dresses";
    }

    @GetMapping("/delete/{id}")
    public final String delete(@PathVariable Integer id) {
        dressService.delete(id);
        return "redirect:/dresses";
    }

}
