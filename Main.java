package com.josh.Heap;

public class Main {

    public static void main(String[] args) {
        Heap<StudentRequest> heap = new Heap<>();
        StudentRequest s1 = new StudentRequest("a", "a", 1);
        StudentRequest s2 = new StudentRequest("b", "a", 2);
        StudentRequest s3 = new StudentRequest("c", "a", 3);
        StudentRequest s4 = new StudentRequest("d", "a", 4);
        StudentRequest s5 = new StudentRequest("e", "a", 5);
        heap.push(s1);
        heap.push(s2);
        heap.push(s3);
        heap.push(s4);
        heap.push(s5);
        System.out.println(heap);

        heap.pop();
        heap.sort();
        System.out.println(heap);

    }
}
