package com.caden.mutilthreading.deadlock;

/**
 * Dead Lock死锁情景再现，死锁的根本原因就是为了让foo1／foo2同时得到两把锁才可以执行
 */
public class DeadLock1 {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void foo1() throws InterruptedException {
        synchronized(lock1) {
            System.out.println("foo1 in A");
            Thread.sleep(1000);
            synchronized(lock2) {//foo2的B未被释放，所以进不来
                System.out.println("foo1 in B");
            }
        }
    }

    private void foo2() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("foo2 in B");
            Thread.sleep(1000);
            synchronized(lock1) {//foo1的A未被释放，所以进不来
                System.out.println("foo2 in A");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock1 obj = new DeadLock1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.foo1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.foo2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main is done");
    }
}
