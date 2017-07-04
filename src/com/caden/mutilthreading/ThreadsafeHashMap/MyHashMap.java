package com.caden.mutilthreading.ThreadsafeHashMap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 */
public class MyHashMap<K, V> implements Map<K, V>, Serializable{
    public static void main(String[] args) {

    }


    private final Map<K, V> map;
    final Object mutex;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public MyHashMap(Map<K, V> map, Object mutex) {
        this.map = map;
        this.mutex = mutex;
    }

    @Override
    public int size() {
//        synchronized (mutex) {
//            return map.size();
//        }
        try {
            lock.readLock().lock();
            return map.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean isEmpty() {
//        synchronized (mutex) {
//            return map.isEmpty();
//        }
        try {
            lock.readLock().lock();
            return map.isEmpty();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
//        synchronized (mutex) {
//            return map.containsKey(key);
//        }
        try {
            lock.readLock().lock();
            return map.containsKey(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        synchronized (mutex) {
            return map.containsValue(value);
        }
    }

    @Override
    public V get(Object key) {
//        synchronized (mutex) {
//            return map.get(key);
//        }
        try {
            lock.readLock().lock();
            return map.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public V put(K key, V value) {
//        synchronized (mutex) {
//            return map.put(key, value);
//        }
        try {
            lock.writeLock().lock();
            return map.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public V remove(Object key) {
//        synchronized (mutex) {
//            return map.remove(key);
//        }
        try {
            lock.writeLock().lock();
            return map.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }
//---------------后面方法就不用写了
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
