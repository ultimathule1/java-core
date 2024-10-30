package ru.sorokin.javacore.hw.multithreading.counters;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    Integer i = 0;
    final Object lock = new Object();

    @Override
    public void incrementVisitCount() {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }

    @Override
    public int getVisitCount() {
        synchronized (lock) {
            return i;
        }
    }
}
