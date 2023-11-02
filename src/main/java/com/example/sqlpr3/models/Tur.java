package com.example.sqlpr3.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tur")
public class Tur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Поле Название не должно быть пустым!")
    private String name;
    @NotBlank(message = "Поле Цена не может быть меньше 0!")
    private int price;
    @NotBlank(message = "Поле Город не должно быть пустым!")
    private String city;
    @Range (min=0, message = "Поле Страна не должно быть пустым!")
    private String country;

    public Tur() {
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
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }





    public Tur(int id, String name, int price, String city, String country){
        this.id = id;
        this.name = name;
        this.price = price;
        this.city = city;
        this.country = country;
    }

}

