package com.example.demo.Mapper;

import com.example.demo.Entity.Films;
import com.example.demo.Entity.KinoFilm;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public interface Mapper {
    Films toFilms(KinoFilm kinoFilm);
}
