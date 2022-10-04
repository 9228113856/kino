package com.example.demo.Repository;

import com.example.demo.Entity.Films;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Films,Long> {
    boolean existsByKinopoiskId(Long kinopoiskId);
}
