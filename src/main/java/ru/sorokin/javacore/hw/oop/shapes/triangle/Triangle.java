package ru.sorokin.javacore.hw.oop.shapes.triangle;

import ru.sorokin.javacore.hw.oop.shapes.Shape;

public class Triangle extends Shape {
    private final double sideA;
    private  final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) throw new IllegalArgumentException("Invalid side");
        if (sideC >= (sideA + sideB) || sideA > (sideB + sideC) || sideB > (sideA + sideC))
            throw new IllegalArgumentException("Property not met: triangle inequality");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double getArea() {
        double semiperimeter = getPerimeter() / 2;
        return Math.sqrt(
                semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC)
        );
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}
