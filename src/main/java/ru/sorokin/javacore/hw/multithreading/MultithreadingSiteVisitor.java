package ru.sorokin.javacore.hw.multithreading;

import ru.sorokin.javacore.hw.multithreading.counters.SiteVisitCounter;

import java.time.Instant;

public class MultithreadingSiteVisitor {
    SiteVisitCounter siteVisitCounter;
    Thread[] threads;
    Instant startTime;
    Instant endTime;

    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = Instant.now();
        threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(siteVisitCounter::incrementVisitCount);
            threads[i].start();
        }
    }

    public void waitUntilAllVisited() throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
        endTime = Instant.now();
    }

    public long getTotalTimeOfHandling() {
        return endTime.toEpochMilli() - startTime.toEpochMilli();
    }
}
