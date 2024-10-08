package ru.sorokin.javacore.hw.oop;

import ru.sorokin.javacore.hw.oop.shapes.ellipse.Circle;
import ru.sorokin.javacore.hw.oop.shapes.ellipse.Ellipse;
import ru.sorokin.javacore.hw.oop.shapes.rectangle.Rectangle;
import ru.sorokin.javacore.hw.oop.shapes.triangle.RegularTriangle;
import ru.sorokin.javacore.hw.oop.shapes.Shape;
import ru.sorokin.javacore.hw.oop.shapes.rectangle.Square;
import ru.sorokin.javacore.hw.oop.shapes.triangle.Triangle;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Shape[] shapes = new Shape[60];
        double sumArea = 0;
        double sumPerimeter = 0;
        double sumAreaTriangle = 0;
        double sumPerimeterTriangle = 0;
        double sumAreaRectangle = 0;
        double sumPerimeterRectangle = 0;

        int ptrValue = 0;

        for (int i = ptrValue, end = ptrValue; i < (end + 10); i++, ptrValue++) { shapes[i] = new Circle(i + 1);}
        for (int i = ptrValue, end = ptrValue; i < (end + 10); i++, ptrValue++) { shapes[i] = new Ellipse(i + 1, i + 2);}
        for (int i = ptrValue, end = ptrValue; i < (end + 10); i++, ptrValue++) { shapes[i] = new Rectangle(i + 1, i + 2);}
        for (int i = ptrValue, end = ptrValue; i < (end + 10); i++, ptrValue++) { shapes[i] = new RegularTriangle(i + 1);}
        for (int i = ptrValue, end = ptrValue; i < (end + 10); i++, ptrValue++) { shapes[i] = new Square(i + 1);}
        for (int i = ptrValue, end = ptrValue; i < (end + 10); i++, ptrValue++) { shapes[i] = new Triangle(i + 1, i + 2, i + 3);}


        for (int i = 0; i < shapes.length; i++) {
            double tempPerimeter = shapes[i].getPerimeter();
            double tempArea = shapes[i].getArea();
            sumPerimeter += tempPerimeter;
            sumArea += tempArea;

            if (shapes[i] instanceof Triangle) {
                sumAreaTriangle += tempArea;
                sumPerimeterTriangle += tempPerimeter;
            } else if (shapes[i] instanceof Rectangle) {
                sumAreaRectangle += tempArea;
                sumPerimeterRectangle += tempPerimeter;
            }

            System.out.println("Shape: " + shapes[i] + " Perimeter: " + tempPerimeter + " Area: " + tempArea);
        }

        System.out.println("Sum of perimeter: " + sumPerimeter);
        System.out.println("Sum of area: " + sumArea);

        System.out.println("Sum of perimeter triangle: " + sumPerimeterTriangle);
        System.out.println("Sum of area triangle: " + sumAreaTriangle);
        System.out.println("Sum of area rectangle: " + sumAreaRectangle);
        System.out.println("Sum of perimeter rectangle: " + sumPerimeterRectangle);

    }
}
