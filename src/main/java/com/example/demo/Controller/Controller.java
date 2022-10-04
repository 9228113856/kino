package com.example.demo.Controller;

import com.example.demo.Entity.DataBaseFiltr;
import com.example.demo.Entity.FilmFiltr;
import com.example.demo.Entity.Films;
import com.example.demo.Service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class Controller {
    private final Service service;
    @GetMapping("/allFilms")
    public List<Films> allFilms(FilmFiltr filmFiltr){
        return service.allFilms(filmFiltr);
    }
    @PostMapping("/allFilms")
    public List<Films> addFilms(FilmFiltr filmFiltr){return service.addFilms(filmFiltr);
        }
        @GetMapping("/dataBaseFilms")
        public List<Films> dataBaseFilms(DataBaseFiltr dataBaseFiltr){
         return service.gerDataBaseFilms(dataBaseFiltr);
        }
    }


