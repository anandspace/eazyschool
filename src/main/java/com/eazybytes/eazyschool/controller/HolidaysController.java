package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.models.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @RequestMapping("/holidays/{display}")
    public String displayHolidayPage(@PathVariable String display, boolean federal,
                                     Model model) {
        model.addAttribute("festival", display != null && (display.equals("festival") || display.equals("all")));
        model.addAttribute("federal", display != null && (display.equals("federal") || display.equals("all")));
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Hallowen", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr.Day", Holiday.Type.FEDERAL),
                new Holiday(" Jul 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labour Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            var festivalHolidays = holidays.stream().filter(holiday -> holiday.getType().equals(type))
                    .collect(Collectors.toList());
            model.addAttribute(type.toString(), festivalHolidays);
        }
        return "holidays";
    }
}
