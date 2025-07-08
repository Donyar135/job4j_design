package ru.job4j.generics;

import java.util.Objects;

public class Predator extends Animal {
    private String name;
    private int age;

    public Predator(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Predator predator = (Predator) o;
        return age == predator.age && Objects.equals(name, predator.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Predator{"
                + "name='"
                + name + '\''
                + ", age="
                + age + '}';
    }
}
