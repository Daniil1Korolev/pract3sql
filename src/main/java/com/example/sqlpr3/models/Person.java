package com.example.sqlpr3.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "person")
public class Person {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

    @NotBlank(message = "Поле Имя не должно быть пустым!")
    private String name;
    @NotBlank(message = "Поле Фамилия не должно быть пустым!")
    private String surname;
    @NotBlank(message = "Поле Отчество не должно быть пустым!")
    private String midname;
    @Range (min=0, message = "Возраст не может быть меньше 0!")
    private int age;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public Person(int id, String name, String surname, String midname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.midname = midname;
        this.age = age;
    }

}
