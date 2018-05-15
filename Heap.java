package com.josh.Heap;

import java.util.Arrays;

/**
 * Created by Josh on 14/05/2018.
 */
public class Heap<T extends Comparable<T>> {

    private int capacity, size;
    private T[] heap;

    public Heap() {
        capacity = 10;
        size = 0;
        heap = (T[]) new Comparable[capacity];
    }

    public void push(T item) {
        resize();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void resize() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }


    private void heapifyUp() {
        int index = size - 1;
        T newVal = heap[index];
        while (index > 0 && newVal.compareTo(parent(index)) > 0) {
            heap[index] = parent(index);
            index = getParentIndex(index);
        }
        heap[index] = newVal;

    }

    public T pop() {
        if (isEmpty()) {
            throw new HeapIsEmptyException("Error there is no heap in the heap");
        } else {
            T deletedValue = heap[0];

            heap[0] = heap[size - 1];
            heapifyDown(size - 1);
            heap[size - 1] = null;

            size--;

            return deletedValue;
        }

    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            swap(0, lastHeapIndex-i);
            heapifyDown(lastHeapIndex - i - 1);
        }
    }

    private void heapifyDown(int lastHeapIndex) {
        int childToSwap;
        for (int index = 0, leftChild = getLeftChildIndex(index), rightChild = getRightChildIndex(index);
             index <= lastHeapIndex; index = childToSwap, leftChild = getLeftChildIndex(index), rightChild = getRightChildIndex(index)) {
            if (leftChild <= lastHeapIndex) {
                childToSwap = rightChild > lastHeapIndex ? leftChild : (heap[leftChild].compareTo(heap[rightChild]) > 0 ? leftChild : rightChild);
                if (heap[index].compareTo(heap[childToSwap]) > 0) {
                    swap(index, childToSwap);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new HeapIsEmptyException("Error there is no heap in the heap");
        } else {
            return heap[0];
        }
    }

    public void swap(Integer elemOneIndex, Integer elemTwoIndex) {
        T temp = heap[elemOneIndex];
        heap[elemOneIndex] = heap[elemTwoIndex];
        heap[elemTwoIndex] = temp;
    }

    public int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public T leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    public T rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    public T parent(int index) {
        return index == 0 ? null : heap[getParentIndex(index)];
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return index != 0 && getParentIndex(index) >= 0;
    }

    public T[] getHeap() {
        return heap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < heap.length; i++) {
            str+=i != heap.length - 1 ? heap[i] + ", " : heap[i];
        }
        str += "]";
        return str;
    }

}