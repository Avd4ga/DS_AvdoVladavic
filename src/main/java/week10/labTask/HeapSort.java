package week10.labTask;

import week10.BinaryHeap;

public class HeapSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        BinaryHeap<Data> heap = new BinaryHeap<>();

        for (Data item : elements) {
            heap.insert(item);
        }

        for (int i = 0; i < elements.length; i++) {
            elements[i] = heap.delMax();
        }
        for (int i = 0; i < elements.length / 2; i++) {
            Data temp = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = temp;
        }
    }
}
