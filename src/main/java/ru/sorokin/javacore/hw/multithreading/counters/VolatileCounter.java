package ru.sorokin.javacore.hw.multithreading.counters;

public class VolatileCounter implements SiteVisitCounter {
    volatile int counter = 0;

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ++counter;
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
