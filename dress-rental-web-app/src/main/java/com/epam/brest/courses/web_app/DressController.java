package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.dto.DressDto;
import com.epam.brest.courses.service.dto.DressDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DressController {

    @Autowired
    private DressDtoServiceImpl dressDtoService;

    @GetMapping(value = "/dresses")
    public final String getDresses(Model model) {
        List<DressDto> dresses = dressDtoService.findAllWithNumberOfOrders();
        model.addAttribute("dresses", dresses);
        return "dresses";
    }


}
