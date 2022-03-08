package ru.netology;

import java.util.concurrent.Callable;

class MyThread extends Thread implements Callable<String> {

    @Override
    public String call() throws Exception {
        int count = 0;
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(2500);
                System.out.printf("Я %s. Всем привет!\n", getName());
                count += 1;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", getName());
        }
        return "Выведено " + count + " строки " + getName() + '\n';
    }
}