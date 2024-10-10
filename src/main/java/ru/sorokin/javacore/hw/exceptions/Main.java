package ru.sorokin.javacore.hw.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //No1-2
        int [] arr = {1,2,3,4,5};
        String s = null;

        try {
            System.out.println(arr[5]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
        }

        try {
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.err.println(e);
        } finally {
            System.out.println("Checking try-blocks is done");
        }

        //3
        WorkWithFile wwf = new WorkWithFile();
        String stringFromWWF = "";

        try {
            stringFromWWF = wwf.readFile();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("I/O exception");
        }

        try {
            wwf.writeFile(stringFromWWF);
        } catch (RuntimeException e) {
            System.err.println("String was not written correctly");
            System.err.println(e);
        }
    }
}
