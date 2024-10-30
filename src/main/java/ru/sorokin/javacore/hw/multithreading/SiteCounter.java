package ru.sorokin.javacore.hw.multithreading;

import ru.sorokin.javacore.hw.multithreading.counters.AtomicIntegerCounter;
import ru.sorokin.javacore.hw.multithreading.counters.ReentrantLockCounter;
import ru.sorokin.javacore.hw.multithreading.counters.SiteVisitCounter;
import ru.sorokin.javacore.hw.multithreading.counters.SynchronizedBlockCounter;
import ru.sorokin.javacore.hw.multithreading.counters.UnsynchronizedCounter;
import ru.sorokin.javacore.hw.multithreading.counters.VolatileCounter;

import java.sql.SQLOutput;
import java.util.List;

public class SiteCounter {
    public static void main(String[] args) {
        List<SiteVisitCounter> siteVisitCounters = List.of(
                new UnsynchronizedCounter(),
                new VolatileCounter(),
                new SynchronizedBlockCounter(),
                new AtomicIntegerCounter(),
                new ReentrantLockCounter()
        );
        long generalTime = 0;

        for (SiteVisitCounter siteVisitCounter : siteVisitCounters) {
            long currentTime;
            MultithreadingSiteVisitor multithreadingSiteVisitor = new MultithreadingSiteVisitor(siteVisitCounter);
            multithreadingSiteVisitor.visitMultithread(200);
            try {
                 multithreadingSiteVisitor.waitUntilAllVisited();
                 currentTime = multithreadingSiteVisitor.getTotalTimeOfHandling();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Current time: " + currentTime);
            System.out.println("Value: " + siteVisitCounter.getVisitCount());
            generalTime += currentTime;
        }

        System.out.println("General time with 10 threads: " + generalTime);
    }


}
