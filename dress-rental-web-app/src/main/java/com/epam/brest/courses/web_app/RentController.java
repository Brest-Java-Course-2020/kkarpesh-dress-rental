package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.dto.RentDto;
import com.epam.brest.courses.service.dto.RentDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RentController {

    @Autowired
    private RentDtoServiceImpl rentDtoService;

    @GetMapping(value = "/rents")
    public final String getRents(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "dateFrom", required = false) LocalDate dateFrom,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "dateTo", required = false) LocalDate dateTo,
            Model model) {
        if (dateFrom == null) {
            dateFrom = LocalDate.MIN;
        }
        if (dateTo == null) {
            dateTo = LocalDate.MAX;
        }
        List<RentDto> rents
                = rentDtoService.findAllWIthDressNameByDate(dateFrom, dateTo);
        model.addAttribute("rents", rents);
        return "rents";


    }

}
