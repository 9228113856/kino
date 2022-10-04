package com.example.demo.Service;

import com.example.demo.Entity.DataBaseFiltr;
import com.example.demo.Entity.FilmFiltr;
import com.example.demo.Entity.Films;
import com.example.demo.Mapper.Mapper;
import com.example.demo.Repository.Repository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    private final Connection connection;
    private final Mapper mapper;
    private final Repository repository;
    @PersistenceContext
    private final EntityManager em;

    public List<Films> allFilms(FilmFiltr filmFiltr){
        return connection.getAllFilms(filmFiltr).stream().map(mapper::toFilms).collect(Collectors.toList());
    }
    public List<Films> addFilms(FilmFiltr filmFiltr){
        return connection.getAllFilms(filmFiltr).stream().map(mapper::toFilms).peek(this::saveFilms).collect(Collectors.toList());
    }

    public void saveFilms(Films films) {
        if (!repository.existsByKinopoiskId(films.getKinopoiskId())){
            repository.save(films);
        }
    }

    public List<Films> gerDataBaseFilms(DataBaseFiltr dataBaseFiltr) {
        if (dataBaseFiltr == null) {
            return null;
        }
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery <Films> criteriaQuery = criteriaBuilder.createQuery(Films.class);
        Root<Films> root = criteriaQuery.from(Films.class);

        Path<Integer> kinopoiskId = root.get("kinopoiskId");
        Path<String> nameRu = root.get("nameRu");
        Path<Integer> year = root.get("year");
        Path<Integer> ratingKinopoisk =root.get("ratingKinopoisk");
        Path<Integer> ratingImdb = root.get("ratingImdb");

        List<Predicate> predicateList = new ArrayList<>(0);
        if (dataBaseFiltr.getKinopoiskId()!=null) {
            predicateList.add(criteriaBuilder.in(kinopoiskId));
        }
            if (dataBaseFiltr.getNameRu()!=null){
                predicateList.add(criteriaBuilder.in(nameRu));
            }

            if (dataBaseFiltr.getYearFromTo()!=null){
                    predicateList.add(criteriaBuilder.in(year));
        }
        if (dataBaseFiltr.getRatingKinopoisk()!=null){
            predicateList.add(criteriaBuilder.in(ratingKinopoisk));
        }
        if (dataBaseFiltr.getRatingImdb()!=null){
            predicateList.add(criteriaBuilder.in(ratingImdb));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[0]));
        TypedQuery<Films> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }
}