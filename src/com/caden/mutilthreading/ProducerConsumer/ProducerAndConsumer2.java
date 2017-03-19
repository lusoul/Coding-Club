package com.caden.mutilthreading.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*   mutext是0，1锁。
*   使用synchronized来做，缺点是当你wait和notify的时候，通知的是lock级别的wait和notify，也就是说如果consumer全都在waiting pool中
*   你consumer唤醒了其他consumer，这时候其他consumer发现queue还是为空，那这个被唤醒的consumer又跑到了waiting pool中等待，这一
*   过程就消耗了时间资源，所以最好的方法就是使用lock.condition级别的wait和notify，创建出两个condition，一个是producers的condition，
*   一个是consumers的condition
* */
public class ProducerAndConsumer2 {
    private Lock lock = new ReentrantLock();
    private List<Integer> list = new ArrayList<>();
    private final static int CAPACITY = 5;
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            try {
                lock.lock();//锁还是只有一个，上锁还是lock，只是wait和notify使用condition来做
                while (list.size() == CAPACITY) {
                    full.await();
                }
                System.out.println("produce: " + val);
                list.add(val++);
                empty.signal();
                Thread.sleep(500);

            } finally {
                lock.unlock();
            }
        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            try {
                lock.lock();
                while (list.size() == 0) {
                    empty.await();
                }
                int ret = list.remove(list.size() - 1);
                System.out.println("consume: " + ret);
                full.signal();
                Thread.sleep(500);

            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ProducerAndConsumer2 pc = new ProducerAndConsumer2();
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
                    pc.consume();
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
                    pc.consume();
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
                    pc.consume();
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
