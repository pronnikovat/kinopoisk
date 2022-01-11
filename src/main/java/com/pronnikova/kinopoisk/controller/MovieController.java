package com.pronnikova.kinopoisk.controller;

import com.pronnikova.kinopoisk.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies")
    public String getTop10(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, Model model) {
        model.addAttribute("moviesList", movieService.getTopByDay(date));
        model.addAttribute("date", date == null ? LocalDate.now() : date);
        return "index";
    }
}
