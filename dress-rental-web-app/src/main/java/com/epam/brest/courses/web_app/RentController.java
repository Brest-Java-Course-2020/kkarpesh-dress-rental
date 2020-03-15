package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.dto.RentDto;
import com.epam.brest.courses.service.dto.RentDtoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
            @RequestParam(value = "dateFrom") String dateFrom,
            @RequestParam(value = "dateTo") String dateTo,
            Model model) {
        LocalDate date1 = LocalDate.parse(dateFrom);
        LocalDate date2 = LocalDate.parse(dateTo);

        List<RentDto> rents
                = rentDtoService.findAllWIthDressNameByDate(date1, date2);
        model.addAttribute("rents", rents);
        return "rents";


    }

}
