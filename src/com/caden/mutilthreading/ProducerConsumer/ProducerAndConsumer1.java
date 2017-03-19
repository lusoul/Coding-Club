package com.caden.mutilthreading.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
*   mutext是0，1锁。
*   使用synchronized来做，缺点是当你wait和notify的时候，通知的是lock级别的wait和notify，也就是说如果consumer全都在waiting pool中
*   你consumer唤醒了其他consumer，这时候其他consumer发现queue还是为空，那这个被唤醒的consumer又跑到了waiting pool中等待，这一
*   过程就消耗了时间资源，所以最好的方法就是使用lock.condition级别的wait和notify，创建出两个condition，一个是producers的condition，
*   一个是consumers的condition
* */
public class ProducerAndConsumer1 {
    private List<Integer> list = new ArrayList<>();
    private Object lock = new Object();
    private static final int CAPACITY = 5;

    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == CAPACITY) {
                    lock.wait();
                }
                System.out.println("produce: " + val);
                list.add(val++);
                lock.notify();
                Thread.sleep(1000);
            }
        }
    }

    public int consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                int ret = list.remove(list.size() - 1);
                System.out.println("consume: " + ret);
                lock.notify();
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer1 pc = new ProducerAndConsumer1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(pc.consume());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(pc.consume());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(pc.consume());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
