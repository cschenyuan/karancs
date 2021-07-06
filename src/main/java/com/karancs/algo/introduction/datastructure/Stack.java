package com.karancs.algo.introduction.datastructure;

/**
 * Created by chenyuan on 2018/1/9.
 */
public class Stack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;
    private int top = -1;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException();
        elementData = new Object[capacity];
    }

    public boolean empty() {
        return top == -1;
    }

    public void push(E e) {
        if (top >= elementData.length)
            throw new StackOverflowError();
        elementData[++top] = e;
        size ++;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (empty())
            throw new StackOverflowError();
        Object e = elementData[top--];
        size --;
        return (E)e;
    }

    public int size() {
        return size;
    }
}
