package com.caden.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock解决死锁问题，它比DeadLockSolution1来的好原因是如果锁很多的话，你notify和wait的调用会是思维逻辑复杂非常多
 * ReentrantLock底层肯定也是synchronized实现，它提供了tryLock()方法就可以很简便的判断是否得到了锁
 */
public class DeadLockSolution2 {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private boolean getLock1 = false;
    private boolean getLock2 = false;

    private void foo1() {
        try {
            acquireLock(lock1, lock2);
            System.out.println("foo1");
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    private void foo2() {
        try {
            acquireLock(lock1, lock2);
            System.out.println("foo2");
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
    //死锁的根本原因就是我们要让foo1/foo2同时获得两把锁才可以执行，该方法就是同时获得两把锁
    private void acquireLock(Lock lock1, Lock lock2) {
        while (true) {//两个锁都没得到就无限循环
            try {
                getLock1 = lock1.tryLock();//是否会得到锁
                getLock2 = lock2.tryLock();//是否会得到锁
            } finally {
                if (getLock1 && getLock2) {
                    return;
                }
                if (getLock1) {
                    lock1.unlock();
                }
                if (getLock2) {
                    lock2.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockSolution2 solution = new DeadLockSolution2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.foo1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.foo2();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main is done");

    }
}
