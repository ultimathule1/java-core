package ru.sorokin.javacore.hw.oop.shapes.ellipse;

public class Circle extends Ellipse {
    private final double radius;

    public Circle(double axis) {
        super(axis, axis);
        radius = axis / 2.0;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}