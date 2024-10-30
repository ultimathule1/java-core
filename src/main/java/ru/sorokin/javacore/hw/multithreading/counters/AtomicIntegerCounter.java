package ru.sorokin.javacore.hw.multithreading.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        return counter.get();
    }
}
