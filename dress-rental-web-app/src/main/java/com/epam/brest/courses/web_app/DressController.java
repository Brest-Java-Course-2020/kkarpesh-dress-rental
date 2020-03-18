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
import java.util.Optional;

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

    @GetMapping("/{id}")
    public final String getById(@PathVariable int id, Model model) {
        Optional<Dress> dress = dressService.findById(id);

        if (dress.isPresent()) {
            model.addAttribute("dress", dress.get());
            return "dresses";
        } else {
            return "dresses";
        }
    }

    @PostMapping
    public final String create(Dress dress){
        dressService.create(dress);
        return "redirect:/dresses";
    }

    @PostMapping("/{id}")
    public final String update(){
        return "redirect:/dresses";
    }

    @GetMapping("/delete/{id}")
    public final String delete(@PathVariable int id){
        dressService.delete(id);
        return "redirect:/dresses";
    }

}
