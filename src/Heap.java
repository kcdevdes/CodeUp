import java.util.Arrays;

/**
 * https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
 */

public class Heap {
    static int[] heap = new int[50];
    static int heapSize = 0;

    public static void main(String[] args) {
        insertMaxHeap(1);
        insertMaxHeap(2);
        insertMaxHeap(3);
        insertMaxHeap(4);
        insertMaxHeap(5);
        insertMaxHeap(6);
        insertMaxHeap(7);
        insertMaxHeap(8);
        insertMaxHeap(9);
        insertMaxHeap(10);
        System.out.println(Arrays.toString(heap));
    }

    static void insertMaxHeap (int x) {
        heap[++heapSize] = x;

        for (int i = heapSize; i > 1; i++) {
            if (heap[i / 2] < heap[i]) {
                int temp = heap[i/2];
                heap[i/2] = heap[i];
                heap[i] = temp;
            } else break;
        }
    }
}