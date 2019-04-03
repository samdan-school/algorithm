package section_1.chapter_6;

public class HeapSort {
    HeapSort() {
        int[] a = new int[]{5, 13, 2, 25, 7, 17, 20, 8, 4};
//        int[] a = new int[]{25, 20, 13, 8};
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            System.out.println(i);
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            maxHeapify(a, 0, i - 1);
        }

        for (int x : a) System.out.print(x + " ");
    }

    private void maxHeapify(int[] a, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l <= n)
            if (a[l] > a[i]) largest = l;
        if (r <= n)
            if (a[r] > a[largest]) largest = r;
        if (largest != i) {
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            maxHeapify(a, largest, n);
        }
    }

    private void buildMaxHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--)
            maxHeapify(a, i, a.length - 1);
    }

    public static void main(String[] args) {
        new HeapSort();
    }
}
