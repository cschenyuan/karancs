package com.karancs.algo.introduction.datastructure;

import com.karancs.algo.introduction.Practice;

/**
 * Created by chenyuan on 2018/1/10.
 */
public class Queue<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;
    private int tail;
    private int head = -1;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity: " + capacity);
        elementData = new Object[capacity];
    }

    public boolean empty() {
        return size == 0;
    }

    @Practice(id = "10-1-4")
    public void enqueue(E e) {
        if (size == elementData.length)
            throw new IllegalStateException("overflow");
        if (tail == elementData.length) {
            tail = 0;
        }
        elementData[tail++] = e;
        if (head < 0)
            head = 0;
        ++ size;
    }

    @Practice(id = "10-1-4")
    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (empty())
            return null;
        Object e = elementData[head++];
        size --;
        if (head == elementData.length)
            head = 0;
        return (E) e;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        for (int i=0; i<11; i++) {
            queue.enqueue(i);
            System.out.println("enqueue => size " + queue.size
                    + " head: " + queue.head + " tail: " + queue.tail);
        }

        for (int i=0; i<11; i++) {
            System.out.println("dequeue => size " + queue.size
                    + " head: " + queue.head + " tail: " + queue.tail);
            queue.dequeue();
        }

        queue.enqueue(0);
        System.out.println("enqueue => size " + queue.size
                    + " head: " + queue.head + " tail: " + queue.tail);
    }

}
