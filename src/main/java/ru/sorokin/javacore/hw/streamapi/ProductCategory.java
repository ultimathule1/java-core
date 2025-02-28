package ru.sorokin.javacore.hw.streamapi;

public enum ProductCategory {
    BOOK("book"),
    CHILDREN_CATEGORY("Children's products"),
    TOYS("Toys");

    private final String name;

    private ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
