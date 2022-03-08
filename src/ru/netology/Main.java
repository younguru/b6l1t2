package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadCount = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        List<MyThread> tasks = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            MyThread thread = new MyThread();
            thread.setName("Поток " + i);
            tasks.add(thread);
        }
        List<Future<String>> resultList;
        System.out.println("Запуск всех потоков: ");
        resultList = threadPool.invokeAll(tasks);
        for (Future<String> result : resultList) {
            System.out.print(result.get());
        }
        System.out.println();
        System.out.println("Запуск всех до первого успешного");
        String fastest = threadPool.invokeAny(tasks);
/*
        почему не сработал этот цикл ожидания завершения всех потоков,
        чтобы вывести результат в самом конце, объясните пожалуйста
        while (!threadPool.isTerminated()) {
        }
*/
        System.out.print("!!!Самый быстрый - " + fastest);
    }
}
