package com.example.demo.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FilmFiltr {
        private String order;

        private String type;

        private int ratingFrom;

        private int ratingTo;

        private int yearFrom;

        private int yearTo;

        private int page;
}
