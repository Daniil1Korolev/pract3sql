package com.example.sqlpr3.repo;

import com.example.sqlpr3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.sqlpr3.models.Person;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
