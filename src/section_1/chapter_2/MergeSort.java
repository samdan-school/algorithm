package section_1.chapter_2;

public class MergeSort {
    private int[] a;

    private MergeSort(int[] a) {
        this.a = a;
        divide(a, 0, a.length - 1);
        for (int x : a) System.out.print(x + ", ");
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
        int m = q - p + 1, n = r - q;
        int[] sa = new int[m + 1], sb = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sa[i] = a[p + i];
            sb[i] = a[q + i + 1];
            if (i == n - 1 && m > n)
                sa[i + 1] = a[q];
        }

        sa[m] = Integer.MAX_VALUE;
        sb[n] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (sa[i] <= sb[j]) {
                a[k] = sa[i];
                i++;
            } else {
                a[k] = sb[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {37, 79, 39, 35, 71, 37, 31, 16, 60, 79, 18, 46, 4, 97, 22, 54, 88, 78, 27, 94, 1};
        new MergeSort(a);
    }
}