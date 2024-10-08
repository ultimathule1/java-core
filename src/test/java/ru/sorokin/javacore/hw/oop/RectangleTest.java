package ru.sorokin.javacore.hw.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sorokin.javacore.hw.oop.shapes.rectangle.Rectangle;

public class RectangleTest {
    Rectangle rectangle;

    @BeforeEach
    public void setUp() {
        rectangle = new Rectangle(5, 10);
    }

    @Test
    public void getArea() {
        double area = rectangle.getArea();
        Assertions.assertEquals(50.0, area);
    }

    @Test
    public void getPerimeter() {
        double perimeter = rectangle.getPerimeter();
        Assertions.assertEquals(30.0, perimeter);
    }

    @Test
    public void createObjects() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Rectangle(0, 10);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Rectangle(10, 0);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Rectangle(0, 0);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Rectangle(10, -1);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Rectangle(-1, 10);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Rectangle(-1, 0);});
    }
}

