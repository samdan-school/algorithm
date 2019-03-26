package section_1.chapter_2;

public class MergeSort {
    private MergeSort() {
        int[] unsorted_array = new int[20];
        for (int i = 0; i < 20; i++)
            unsorted_array[i] = (int) Math.round(Math.random() * 100);


    }

    void divide(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            divide(a, p, q);
            divide(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    void merge(int[] a, int p, int q, int r) {
        int m = q - p, n = r - q;
    }

    void mergeSort(int[] a) {
        int l = a.length;
        divide(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        new MergeSort();
    }
}
