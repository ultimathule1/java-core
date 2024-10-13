package ru.sorokin.javacore.hw.collections;

import java.util.Objects;

public class User {
    private final String name;
    private final int age;
    private final Long userId;

    public User(String name, int age, Long userId) {
        if (age < 0 || age > 180) {
            throw new IllegalArgumentException("Age must be between 0 and 180");
        }
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, userId);
    }
}
