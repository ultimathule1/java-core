package ru.sorokin.javacore.hw.multithreading_II;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        //DataProcessor dataProcessor = new DataProcessor(1); //Здесь была доп проверка
        DataProcessor dataProcessor = new DataProcessor(10);
        List<String> tasksNames = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            List<Integer> task = generateNumberList(2000);
            try {
                tasksNames.add(dataProcessor.addTask(task));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(dataProcessor.getActiveTasks() > 0) {
            System.out.println("Waiting for tasks to complete");
            System.out.println("Active tasks: " + dataProcessor.getActiveTasks());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All tasks completed");

        tasksNames.forEach(taskName -> {
            Optional<Integer> temp = dataProcessor.getResultByTaskName(taskName);
            temp.ifPresent(val -> System.out.println(taskName + ": " + val));
        });
    }
    
    private static List<Integer> generateNumberList(int sizeList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sizeList; i++) {
            list.add(ThreadLocalRandom.current().nextInt(1, 100));
        }

        return list;
    }
}
