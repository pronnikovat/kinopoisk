package com.pronnikova.kinopoisk.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int position;
    private double rating;
    private String name;
    private int year;
    private int votes;
    private LocalDate topDate;

    public Movie() {
    }

    public Movie(long id, int position, double rating, String name, int year, int votes, LocalDate topDate) {
        this.id = id;
        this.position = position;
        this.rating = rating;
        this.name = name;
        this.year = year;
        this.votes = votes;
        this.topDate = topDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public LocalDate getTopDate() {
        return topDate;
    }

    public void setTopDate(LocalDate topDate) {
        this.topDate = topDate;
    }
}
