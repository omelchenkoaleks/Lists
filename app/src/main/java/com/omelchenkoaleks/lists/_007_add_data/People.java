package com.omelchenkoaleks.lists._007_add_data;

public class People {
    private String name;
    private int age;
    private String position;

    public People(int age, String name, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
