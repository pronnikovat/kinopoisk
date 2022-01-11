package com.pronnikova.kinopoisk.service;

import com.pronnikova.kinopoisk.model.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface MovieService {
    List<Movie> getTopByDay(LocalDate date);
}
