package com.caden.designpattern.filteringiterator;

import java.util.Iterator;

public class FilteringIterator<E> implements Iterator<E> {
    private IObjectTest<E> filter;
    private Iterator<E> iterator;

    private E next;

    public FilteringIterator(Iterator myIterator, IObjectTest myTest) {
        filter = myTest;
        iterator = myIterator;
        findNext();//初始化时就定位到一个合法位置
    }

    private void findNext() {
        while (iterator.hasNext()) {
            this.next = iterator.next();
            if (null == filter || filter.test(this.next)) {
                return;
            }
        }
        this.next = null;//这句很重要
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public E next() {
        E ret = this.next;
        this.findNext();
        return ret;
    }

    public void remove() {

    }
}
