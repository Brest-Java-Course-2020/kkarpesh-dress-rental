package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.service.DressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DressController {

    @Autowired
    private DressServiceImpl dressServiceImpl;

    @GetMapping(value = "/dresses")
    public final String getDresses(Model model){
        List<Dress> dresses = dressServiceImpl.findAll();
        model.addAttribute("dresses", dresses);
        return "dresses";
    }


}
