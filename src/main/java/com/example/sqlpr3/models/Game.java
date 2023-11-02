package com.example.sqlpr3.models;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Поле Имя не должно быть пустым!")
    private String name;
    @NotBlank(message = "Поле Жанр не должно быть пустым!")
    private String janr;
    @NotBlank(message = "Поле Новинка не должно быть пустым!")
    private String novinka;
    @Range(min=0, message = "Плата не может быть меньше 0!")
    private String plata;

    public Game() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getJanr() {return janr;}

    public void setJanr(String janr) {
        this.janr = janr;
    }

    public String getNovinka() {
        return novinka;
    }

    public void setNovinka(String novinka) {
        this.novinka = novinka;
    }

    public String getPlata() {
        return plata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }



    public Game(int id, String name, String janr, String novinka, String plata){
        this.id = id;
        this.name = name;
        this.janr = janr;
        this.novinka = novinka;
        this.plata = plata;
    }
}
