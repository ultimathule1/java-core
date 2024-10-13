package ru.sorokin.javacore.hw.oop.shapes.triangle;

public class RegularTriangle extends Triangle {
    private final double side;

    public RegularTriangle(double side) {
        super(side, side, side);
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * ((side * side) / 2);
    }

    @Override
    public double getPerimeter() {
        return side * 3;
    }

    @Override
    public String toString() {
        return "RegularTriangle{" +
                "side=" + side +
                '}';
    }
}
