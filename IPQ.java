package com.josh.Heap;

/**
 * Created by Josh on 15/05/2018.
 */
public interface IPQ<T> {
    public void push(int key, T element);
    public int size();
    public boolean isEmpty();
    public T pop();
    public T peek();
    public void printPQueue();
}
