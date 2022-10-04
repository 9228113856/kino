package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "films")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kinopoiskId")
    private Long kinopoiskId;
    @Column(name = "nameRu")
    private String nameRu;
    @Column(name = "year")
    private Integer year;
    @Column(name = "ratingKinopoisk")
    private Integer ratingKinopoisk;
    @Column(name = "ratingImdb")
    private Integer ratingImdb;
    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Films)) return false;
        Films films = (Films) o;
        return Objects.equals(id, films.id) && Objects.equals(kinopoiskId, films.kinopoiskId) && Objects.equals(nameRu, films.nameRu) && Objects.equals(year, films.year) && Objects.equals(ratingKinopoisk, films.ratingKinopoisk) && Objects.equals(ratingImdb, films.ratingImdb) && Objects.equals(description, films.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kinopoiskId, nameRu, year, ratingKinopoisk, ratingImdb, description);
    }


}
