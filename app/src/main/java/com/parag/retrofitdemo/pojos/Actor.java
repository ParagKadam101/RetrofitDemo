package com.parag.retrofitdemo.pojos;


public class Actor {
    private String name, age, film;


    public Actor(){}

    public Actor(String name, String age, String film) {
        this.name = name;
        this.age = age;
        this.film = film;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", film='" + film + '\'' +
                '}';
    }
}
