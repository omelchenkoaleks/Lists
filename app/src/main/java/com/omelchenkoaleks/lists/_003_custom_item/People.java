package com.omelchenkoaleks.lists._003_custom_item;

public class People {
    private String name;
    private int age;
    private String position;

    public People(String name, int age, String position) {
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
