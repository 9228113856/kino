package com.example.demo.Service;

import com.example.demo.Entity.FilmFiltr;
import com.example.demo.Entity.Films;
import com.example.demo.Entity.KinoFilm;
import com.example.demo.Entity.ListFilms;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class Connection {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public List<KinoFilm> getAllFilms(FilmFiltr filmFiltr) {
        HttpHeaders httpHeaders = new HttpHeaders();


        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY", "819e978a-4bc7-4ff2-b1b4-4a1dea9d63ed");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<ListFilms> response = restTemplate().exchange(allUrl(filmFiltr), HttpMethod.GET, httpEntity, ListFilms.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getItems() != null) {
            return response.getBody().getItems();
        } else {
            return new ArrayList<>();
        }
    }

//    public String allUrl(FilmFiltr filmFiltr) {
//        String URL = "https://kinopoiskapiunofficial.tech/api/v2.2/films";
//        final String fullURL = String.join("",URL);
//        final Optional <FilmFiltr> optFilter = Optional.ofNullable(filmFiltr);
//
//        List<String> allParams = new ArrayList<>();
//
//        optFilter.map(FilmFiltr::getType).ifPresent(type -> allParams.add(String.join("=", "type", type)));
//        optFilter.map(FilmFiltr::getOrder).ifPresent(order -> allParams.add(String.join("=", "order", order)));
//        optFilter.map(FilmFiltr::getRatingFrom).ifPresent(ratingFrom -> allParams.add(String.join("=", "ratingFrom", ratingFrom.toString())));
//        optFilter.map(FilmFiltr::getRatingTo).ifPresent(ratingTo -> allParams.add(String.join("=", "ratingTo", ratingTo.toString())));
//        optFilter.map(FilmFiltr::getYearFrom).ifPresent(yearFrom -> allParams.add(String.join("=", "yearFrom", yearFrom.toString())));
//        optFilter.map(FilmFiltr::getYearTo).ifPresent(yearTo -> allParams.add(String.join("=", "yearTo", yearTo.toString())));
//        optFilter.map(FilmFiltr::getPage).ifPresent(page -> allParams.add(String.join("=", "yearTo", page.toString())));
//
//        return fullURL;
//
//    }
String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films/";
    String urlId = "https://kinopoiskapiunofficial.tech/api/v2.2/films/{id}";

    public String allUrl(FilmFiltr filmFiltr){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        final var optionalParam = Optional.ofNullable(filmFiltr);
        optionalParam.map(FilmFiltr::getOrder).ifPresent(order -> builder.queryParam("order", order));
        optionalParam.map(FilmFiltr::getType).ifPresent(tp -> builder.queryParam("type", tp));
        optionalParam.map(FilmFiltr::getRatingFrom).ifPresent(rfr -> builder.queryParam("ratingFrom", rfr));
        optionalParam.map(FilmFiltr::getRatingTo).ifPresent(rto -> builder.queryParam("ratingTo", rto));
        optionalParam.map(FilmFiltr::getYearFrom).ifPresent(yfr -> builder.queryParam("yearFrom", yfr));
        optionalParam.map(FilmFiltr::getYearTo).ifPresent(yto -> builder.queryParam("yearTo", yto));
        optionalParam.map(FilmFiltr::getPage).ifPresent(pg -> builder.queryParam("page", pg));
        final var request = builder.build().toUriString();
        return request;
    }
}















