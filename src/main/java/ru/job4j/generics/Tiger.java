package ru.job4j.generics;

import java.util.Objects;

public class Tiger extends Predator {
    private String name;
    private int age;

    public Tiger(String name, int age) {
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
        Tiger tiger = (Tiger) o;
        return age == tiger.age && Objects.equals(name, tiger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "name='"
                + name + '\''
                + ", age="
                + age + '}';
    }
}
