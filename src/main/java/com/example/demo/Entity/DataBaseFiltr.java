package com.example.demo.Entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DataBaseFiltr {
    private List<Long> kinopoiskId;
    private List<String> nameRu;
    private List<Integer> ratingKinopoisk;
    private List<Integer> ratingImdb;
    private YearFromTo yearFromTo;
    private RatingFromTo ratingFromTo;
}
