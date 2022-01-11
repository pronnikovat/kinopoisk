package com.pronnikova.kinopoisk.repository;

import com.pronnikova.kinopoisk.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findTop10ByTopDateOrderByPositionAsc(LocalDate date);
}
