package com.epam.brest.courses.web_app;

import com.epam.brest.courses.model.Dress;
import com.epam.brest.courses.model.Rent;
import com.epam.brest.courses.model.dto.RentDto;
import com.epam.brest.courses.service.RentServiceImpl;
import com.epam.brest.courses.service.dto.RentDtoServiceImpl;
import com.epam.brest.courses.service_api.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentDtoServiceImpl rentDtoService;

    @Autowired
    private RentServiceImpl rentService;

    @Autowired
    private DressService dressService;

    @GetMapping
    public final String getRents(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "dateFrom", required = false) LocalDate dateFrom,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "dateTo", required = false) LocalDate dateTo,
            ModelMap modelMap) {
        if (dateFrom == null) {
            dateFrom = LocalDate.of(2000, 01, 01);
        }
        if (dateTo == null) {
            dateTo = LocalDate.of(2050,01,01);
        }
        List<RentDto> rents
                = rentDtoService.findAllWIthDressNameByDate(dateFrom, dateTo);

        Rent rent = new Rent();
        List<Dress> dresses = dressService.findAll();
        modelMap.addAttribute("rents", rents);
        modelMap.addAttribute("dateFrom", dateFrom);
        modelMap.addAttribute("dateTo", dateTo);
        modelMap.addAttribute("rent", rent);
        modelMap.addAttribute("dresses", dresses);
        return "rents";
    }

    @PostMapping
    public final String createOrUpdate(Rent rent) {
        if (rent.getRentId() == null) {
            rentService.create(rent);
        } else {
            rentService.update(rent);
        }
        return "redirect:/rents";
    }

    @GetMapping("/delete/{id}")
    public final String delete(@PathVariable Integer id) {
        rentService.delete(id);
        return "redirect:/rents";
    }

}
