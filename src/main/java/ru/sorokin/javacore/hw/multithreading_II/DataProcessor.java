package ru.sorokin.javacore.hw.multithreading_II;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {
    private final ExecutorService taskManagementExecutor;
    private final AtomicInteger counterTasks;
    private final AtomicInteger counterActiveTasks;
    private final Map<String, Integer> resultTasks;

    public DataProcessor(int numThreads) {
        taskManagementExecutor = Executors.newFixedThreadPool(numThreads);
        counterTasks = new AtomicInteger(0);
        counterActiveTasks = new AtomicInteger(0);
        resultTasks = new HashMap<>();
    }

    public String addTask(List<Integer> list) throws InterruptedException {
        String taskName = "Task" + counterTasks.incrementAndGet();
        CalculateSumTask calculateSumTask = new CalculateSumTask(list, taskName);

        CompletableFuture<Integer> taskFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return calculateSumTask.call();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }, taskManagementExecutor);

        counterActiveTasks.incrementAndGet();
        taskFuture.thenAccept(res -> {
            synchronized (resultTasks) {
                resultTasks.put(taskName, res);
                counterActiveTasks.decrementAndGet();
            }
        });

        return taskName;
    }

    public void shutdown() {
        taskManagementExecutor.shutdown();
        try {
            boolean isTerminated = taskManagementExecutor.awaitTermination(10, TimeUnit.MILLISECONDS);
            if (!isTerminated) {
                taskManagementExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            taskManagementExecutor.shutdownNow();
            throw new RuntimeException(e);
        }
    }

    public int getActiveTasks() {
        return counterActiveTasks.get();
    }

    public Optional<Integer> getResultByTaskName(String taskName) {
        synchronized (resultTasks) {
            return Optional.ofNullable(resultTasks.get(taskName));
        }
    }
}