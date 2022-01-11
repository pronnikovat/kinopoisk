package com.pronnikova.kinopoisk.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface KinopoiskParser {
    void parse() throws IOException;
}
