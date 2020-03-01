package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DressController {

    @Autowired
    private DressService dressService;

    @GetMapping(value = "/")
    public final String defaultPageRedirect(){
        return "redirect:dresses";
    }

    @GetMapping(value = "/dresses")
    public final String getDresses(Model model){
        List<Dress> dresses = dressService.getDresses();
        model.addAttribute("dresses", dresses);
        return "dresses";
    }


}
