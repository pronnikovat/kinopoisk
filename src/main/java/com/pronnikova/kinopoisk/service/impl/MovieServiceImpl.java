package com.pronnikova.kinopoisk.service.impl;

import com.pronnikova.kinopoisk.repository.MovieRepository;
import com.pronnikova.kinopoisk.model.Movie;
import com.pronnikova.kinopoisk.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Cacheable(value = "movies")
    public List<Movie> getTopByDay(LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        return movieRepository.findTop10ByTopDateOrderByPositionAsc(date);
    }
}
