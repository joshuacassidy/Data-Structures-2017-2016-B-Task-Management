package com.josh.Heap.Tests;

import com.josh.Heap.Heap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    private Heap<Integer> heap;

    @Before
    public void setUp() throws Exception {
        heap = new Heap<>();
        heap.push(10);
        heap.push(5);
        heap.push(3);
    }

    @Test
    public void getRightChildIndex() throws Exception {
        assertEquals(2, heap.getRightChildIndex(0));
        assertEquals(4, heap.getRightChildIndex(1));
        assertEquals(6, heap.getRightChildIndex(2));
    }

    @Test
    public void getLeftChildIndex() throws Exception {
        assertEquals(1, heap.getLeftChildIndex(0));
        assertEquals(3, heap.getLeftChildIndex(1));
        assertEquals(5, heap.getLeftChildIndex(2));
    }

    @Test
    public void getParentIndex() throws Exception {
        assertEquals(0, heap.getParentIndex(0));
        assertEquals(0, heap.getParentIndex(1));
        assertEquals(0, heap.getParentIndex(2));
    }

    @Test
    public void leftChild() throws Exception {
        assertEquals((Integer) 5, heap.leftChild(0));
        assertEquals(null, heap.leftChild(1));
        assertEquals(null, heap.leftChild(2));
    }

    @Test
    public void rightChild() throws Exception {
        assertEquals((Integer) 3, heap.rightChild(0));
        assertEquals(null, heap.rightChild(1));
        assertEquals(null, heap.rightChild(2));
    }

    @Test
    public void parent() throws Exception {
        assertEquals((Integer) 10, heap.parent(1));
        assertEquals((Integer) 10, heap.parent(2));
    }

    @Test
    public void testingRootNodeForParent() throws Exception {
        assertEquals(null, heap.parent(0));
    }

    @Test
    public void hasLeftChild() throws Exception {
        assertEquals(true, heap.hasLeftChild(0));
        assertEquals(false, heap.hasLeftChild(1));
        assertEquals(false, heap.hasLeftChild(2));
    }

    @Test
    public void hasRightChild() throws Exception {
        assertEquals(true, heap.hasRightChild(0));
        assertEquals(false, heap.hasRightChild(1));
        assertEquals(false, heap.hasRightChild(2));
    }

    @Test
    public void hasParent() throws Exception {
        assertEquals(false, heap.hasParent(0));
        assertEquals(true, heap.hasParent(1));
        assertEquals(true, heap.hasParent(2));
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        assertEquals(false, heap.isEmpty());
        heap.pop();
        heap.pop();
        heap.pop();
        assertEquals(true, heap.isEmpty());
    }

    @org.junit.Test
    public void peek() throws Exception {
        assertEquals((Integer) 10, heap.peek());
    }

    @org.junit.Test
    public void pop() throws Exception {
        assertEquals((Integer) 10, heap.pop());
    }

    @org.junit.Test
    public void push() throws Exception {
        Integer[] tempHeap = heap.getHeap();
        assertEquals((Object) 10, tempHeap[0]);
        assertEquals((Object) 5, tempHeap[1]);
        assertEquals((Object) 3, tempHeap[2]);
        assertEquals((Integer) 10, heap.peek());
        assertEquals((Integer) 10, heap.pop());
        assertEquals((Integer) 5, heap.peek());
        assertEquals((Integer) 5, heap.pop());
        assertEquals((Integer) 3, heap.peek());
        assertEquals((Integer) 3, heap.pop());
    }

}
