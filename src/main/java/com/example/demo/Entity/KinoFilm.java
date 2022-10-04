package com.example.demo.Entity;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class KinoFilm {
    private Long kinopoiskId;

    private String nameRu;

    private Integer year;

    private Integer ratingKinopoisk;

    private Integer ratingImdb;

    private String description;
}
