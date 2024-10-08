package ru.sorokin.javacore.hw.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sorokin.javacore.hw.oop.shapes.triangle.Triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TriangleTest {
    private Triangle triangle;

    @BeforeEach
    public void setUp() {
        triangle = new Triangle(4,5,6);
    }

    @Test
    public void getArea() {
        BigDecimal bigDecimal = BigDecimal.valueOf(triangle.getArea()).setScale(6, RoundingMode.HALF_UP);
        double area = bigDecimal.doubleValue();
        Assertions.assertEquals(9.921567, area);
    }

    @Test
    public void getPerimeter() {
        double perimeter = triangle.getPerimeter();
        Assertions.assertEquals(15.0, perimeter);
    }

    @Test
    public void createObjects() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(4,5,11);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(4,5,0);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(-1,5,5);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(3,-2,4);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(0,0,0);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(0,3,0);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(3,0,0);});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Triangle(-1,0,0);});
    }
}
