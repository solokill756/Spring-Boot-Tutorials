package com.springtutorial.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springtutorial.springdemo.model.Alien;

public interface AlenRepo extends JpaRepository<Alien, Integer> {

    @Query("FROM Alien WHERE tech = ?1 ORDER BY aname")
    List<Alien> findByTechSorted(String tech);

}
