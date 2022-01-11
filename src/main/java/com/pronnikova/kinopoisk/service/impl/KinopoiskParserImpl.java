package com.pronnikova.kinopoisk.service.impl;

import com.pronnikova.kinopoisk.model.Movie;
import com.pronnikova.kinopoisk.repository.MovieRepository;
import com.pronnikova.kinopoisk.service.KinopoiskParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KinopoiskParserImpl implements KinopoiskParser {
    private final MovieRepository movieRepository;

    @Autowired
    public KinopoiskParserImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void parse() throws IOException {
        Document document = Jsoup.connect("https://www.kinopoisk.ru/top")
                .userAgent("Mozilla")
                .timeout(5000)
                .referrer("https://google.com")
                .get();
        List<Movie> moviesList = new ArrayList<>();
        Elements movies = document.getElementsByClass("desktop-rating-selection-film-item");
        for (Element movie : movies) {
            moviesList.add(preparedElements(movie));
        }
        movieRepository.saveAll(moviesList);
    }

    private static Movie preparedElements(Element element) {
        Movie movie = new Movie();
        movie.setPosition(Integer.parseInt(element.getElementsByClass("film-item-rating-position__position").text()));
        movie.setRating(Double.parseDouble(element.getElementsByClass("rating__value rating__value_positive").text()));
        movie.setName(element.getElementsByClass("selection-film-item-meta__name").text());
        String nameAndYear = element.getElementsByClass("selection-film-item-meta__original-name").text();
        movie.setYear(Integer.parseInt(nameAndYear.substring(nameAndYear.length() - 4)));
        movie.setVotes(Integer.parseInt(element.getElementsByClass("rating__count").text().replaceAll("\\s+", "")));
        movie.setTopDate(LocalDate.now());
        return movie;
    }
}
