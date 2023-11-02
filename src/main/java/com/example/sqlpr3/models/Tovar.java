package com.example.sqlpr3.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tovar")
public class Tovar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Поле Название не должно быть пустым!")
    private String name;
    @NotBlank(message = "Поле Цена не может быть меньше 0!")
    private int price;
    @NotBlank(message = "Поле Кол-во не может быть меньше 0!")
    private int kolvo;
    @Range(min=0, message = "Поле Вид не должно быть пустым!")
    private String vid;

    public Tovar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }



    public Tovar(int id, int price, int kolvo, String name, String vid){
        this.id = id;
        this.price = price;
        this.kolvo = kolvo;
        this.name = name;
        this.vid = vid;
    }

}
