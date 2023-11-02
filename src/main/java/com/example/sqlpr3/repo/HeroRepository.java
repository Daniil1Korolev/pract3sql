package com.example.sqlpr3.repo;

import com.example.sqlpr3.models.Hero;
import com.example.sqlpr3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

}
