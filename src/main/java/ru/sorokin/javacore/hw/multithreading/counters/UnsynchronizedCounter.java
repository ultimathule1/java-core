package ru.sorokin.javacore.hw.multithreading.counters;

public class UnsynchronizedCounter implements SiteVisitCounter {
    int counter;

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter++;
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
