package com.pronnikova.kinopoisk;

import com.pronnikova.kinopoisk.model.Movie;
import com.pronnikova.kinopoisk.repository.MovieRepository;
import com.pronnikova.kinopoisk.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableScheduling
public class KinopoiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinopoiskApplication.class, args);
        System.out.println();
    }

}
