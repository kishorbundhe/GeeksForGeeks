package Practice;

import java.lang.Math;

public class Heap {
    static int l, r, heap_size, large, temp;
    static int[] input = {1, 5, 6, 2, 90, 45, 85};
    static int[] heap = new int[input.length + 1];

    public static void main(String[] args) {
        heap[0] = 0;
        for (int i = 0; i < input.length; i++) {
            heap[i + 1] = input[i];
        }
        heap_size = heap.length - 1;
        buildmaxheap();
        extractMax();
        increaseKey(5, 1000);
        heapSort();
        for (int i = 1; i <= 7; i++) {
            System.out.println(heap[i]);
        }

    }

    private static void max_heapify(int i) {
        l = 2 * i;
        r = 2 * i + 1;
        large = i;
        if (l <= heap_size && heap[l] > heap[large]) {
            large = l;
        }
        if (r <= heap_size && heap[r] > heap[large]) {
            large = r;
        }
        if (large != i) {

            temp = heap[i];
            heap[i] = heap[large];
            heap[large] = temp;
            max_heapify(large);
        }

    }

    static void buildmaxheap() {
        int noOfElementInHeap = heap_size;
        int startOfNonLeaf = (int) Math.floor(heap_size / 2);
        for (int i = startOfNonLeaf; i >= 1; i--) {
            max_heapify(i);
        }
    }

    private static void extractMax() {
        temp = heap[1];
        heap[1] = heap[heap_size];
        heap[heap_size] = temp;
        heap_size = heap_size - 1;
        buildmaxheap();
    }

    private static void increaseKey(int i, int offset) {
        heap[i] += offset;
        int root = 1;
        int parent;
        if (i < heap_size && i != root) {
            while (i > root) {
                parent = i / 2;
                if (heap[i] > heap[parent]) {
                    temp = heap[i];
                    heap[i] = heap[parent];
                    heap[parent] = temp;

                }
                i = parent;
            }
        }
    }

    private static void heapSort() {
        int lastIndex;
        int root = 1;
        while (heap_size != 1) {
            lastIndex = heap_size;
            temp = heap[lastIndex];
            heap[lastIndex] = heap[root];
            heap[root] = temp;
            heap_size = heap_size - 1;
            max_heapify(root);
        }
    }


}

