package ru.job4j.generics;

public class Predator extends Animal {
    private String name;
    private int age;

    public Predator(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Predator{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
