package ru.job4j.generics;

public class Tiger extends Predator {
    private String name;
    private int age;

    public Tiger(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return "Tiger{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}