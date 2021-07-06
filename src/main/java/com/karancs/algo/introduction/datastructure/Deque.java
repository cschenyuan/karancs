package com.karancs.algo.introduction.datastructure;

/**
 * Created by chenyuan on 2018/1/11.
 */
public class Deque<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int head;
    private int tail;
    private int size;

    public Deque() {
        this(DEFAULT_CAPACITY);
    }

    public Deque(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity: " + capacity);
        elementData = new Object[capacity];
        tail = elementData.length;
    }

    public void enqueueByTail(E e) {
        elementData[--tail] = e;
        ++ size;
    }

    public void enqueueByHead(E e) {
        elementData[head++] = e;
        ++ size;
    }

    @SuppressWarnings("unchecked")
    public E dequeueByTail() {
        Object e = elementData[++tail];
        return (E)e;
    }
}
