package ru.sorokin.javacore.hw.oop.shapes.rectangle;

import ru.sorokin.javacore.hw.oop.shapes.Shape;

public class Rectangle extends Shape {
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        if ((width <= 0 || length <= 0) && (width == length)) throw new IllegalArgumentException("Side must be positive");
        if (width <= 0 || length <= 0) throw new IllegalArgumentException("Invalid width or length");
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}