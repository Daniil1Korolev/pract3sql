package com.example.sqlpr3.repo;

import com.example.sqlpr3.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}