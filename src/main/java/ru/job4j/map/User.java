package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, Calendar birthday, int children) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        Calendar birthday = Calendar.getInstance();

        User user1 = new User("Alex", birthday, 21);
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int backed1 = hash1 & 15;

        User user2 = new User("Alex", birthday, 21);
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int backed2 = hash2 & 15;

        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.printf("user1 - хэшкод: %s, хэш: %s, бакет: %s, ",
                hashCode1, hash1, backed1);
        System.out.printf("user2 - хэшкод: %s, хэш: %s, бакет: %s",
                hashCode2, hash2, backed2);

        System.out.println("\nКарта: " + map);
        System.out.println("Размер карты: " + map.size());
    }
}
