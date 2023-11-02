package com.example.sqlpr3.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Поле Имя не должно быть пустым!")
    private String name;
    @NotBlank(message = "Поле Сила не должно быть пустым!")
    private String sila;
    @NotBlank(message = "Поле Аттрибут не должно быть пустым!")
    private String attribute;
    @Range(min=0, message = "Поле Рарность не должно быть пустым!")
    private String rare;

    public Hero() {
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

    public String getSila() {
        return sila;
    }

    public void setSila(String sila) {
        this.sila = sila;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }



    public Hero(int id, String name, String sila, String attribute, String rare){
        this.id = id;
        this.name = name;
        this.sila = sila;
        this.attribute = attribute;
        this.rare = rare;
    }

}
