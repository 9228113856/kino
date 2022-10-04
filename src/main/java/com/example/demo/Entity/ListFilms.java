package com.example.demo.Entity;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ListFilms {
    private List<KinoFilm> items;
}
