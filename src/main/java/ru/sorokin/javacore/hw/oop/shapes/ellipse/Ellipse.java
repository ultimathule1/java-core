package ru.sorokin.javacore.hw.oop.shapes.ellipse;

import ru.sorokin.javacore.hw.oop.shapes.Shape;

public class Ellipse extends Shape {
    private final double majorAxis;
    private final double minorAxis;

    public Ellipse(double majorAxis, double minorAxis) {
        if (majorAxis <= 0 || minorAxis <= 0) throw new IllegalArgumentException("Invalid axis");
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double getArea() {
        return Math.PI * ((majorAxis * minorAxis) / 2);
    }

    @Override
    public double getPerimeter() {
        double semiMajorAxis = majorAxis / 2;
        double semiMinorAxis = minorAxis / 2;

        return Math.sqrt((semiMajorAxis * semiMajorAxis + semiMinorAxis * semiMinorAxis) / 2) * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "majorAxis=" + majorAxis +
                ", minorAxis=" + minorAxis +
                '}';
    }
}