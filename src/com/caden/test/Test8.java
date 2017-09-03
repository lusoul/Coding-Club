package com.caden.test;

import java.util.LinkedList;

public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

class ProducerConsumer {
    int LIMIT;
    LinkedList<Integer> list;
    public ProducerConsumer(int size){
        LIMIT = size;
        list = new LinkedList<>();
    }
    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            list.offer(val++);
            Thread.sleep(256);
            System.out.println(val);
            if (list.size() == LIMIT) break;
        }
    }
    public void consume(){
        int count = 0;
        while (!list.isEmpty()) {
            count++;
            if (count >= list.size()) continue;
            if (count == LIMIT - 1) break;
            int val = list.get(count);
            System.out.println("Consumed: " + val);

        }
    }
}

