package section_1.chapter_2;

public class MergeSort {
    private MergeSort() {
        int[] a = new int[20];
        for (int i = 0; i < 20; i++)
            a[i] = (int) Math.round(Math.random() * 100);
        mergeSort(a);
        for (int x : a) System.out.print(x + " ");
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
        int m = q - p, n = r - q + 1;
        int[] sa = new int[m], sb = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = a[p + i];
            sb[i] = a[q + 1 + i];
            if (i == n - 1 && n < m)
                sb[i + 1] = a[q + i + 2];
        }
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            if (sa[j] > sb[k]) {
                a[i] = sa[j];
                j++;
            }
            if (sa[j] < sb[k]) {
                a[i] = sb[j];
                k++;
            }
            i++;
        }
        while (j < m) {
            a[i] = sa[j];
            j++;
            i++;
        }
        while (k < n) {
            a[i] = sb[k];
            k++;
            i++;
        }
    }

    void mergeSort(int[] a) {
        int l = a.length;
        divide(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        new MergeSort();
    }

}
