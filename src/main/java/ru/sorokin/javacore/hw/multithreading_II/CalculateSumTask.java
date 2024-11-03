package ru.sorokin.javacore.hw.multithreading_II;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculateSumTask implements Callable<Integer> {
    private final String name;
    private final List<Integer> integerList;
    private Integer sum;

    public CalculateSumTask(List<Integer> integerList, String name) {
        this.integerList = integerList;
        this.name = name;
        sum = 0;
    }

    @Override
    public Integer call() throws InterruptedException {
        System.out.printf("Calculating in thread: %s; name: %s\n", Thread.currentThread().getName(), name);
        Thread.sleep(200);
        return integerList.stream().mapToInt(Integer::intValue).sum();
    }
}
