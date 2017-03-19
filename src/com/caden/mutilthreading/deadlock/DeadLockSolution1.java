package com.caden.mutilthreading.deadlock;

/*
*   使用synchronized代码块解决死锁问题
* */
public class DeadLockSolution1 {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void foo1() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("foo1 in A");
            Thread.sleep(1000);
            lock1.wait();
            synchronized (lock2) {
                System.out.println("foo1 in B");
            }
        }
    }

    private void foo2() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("foo2 in B");
            Thread.sleep(1000);
            synchronized (lock1) {
                System.out.println("foo2 in A");
                lock1.notify();//如果直接写notify()是错的，需要标注有A的存在
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockSolution1 solution = new DeadLockSolution1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.foo1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.foo2();
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
