package section_1.chapter_7;

public class QuickSort {
    private int[] a = new int[]{2, 8, 7, 1, 3, 5, 6, 4};

    private QuickSort() {
        qs(0, a.length - 1);
        for (int x : a) System.out.print(x + " ");
    }

    private void qs(int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            qs(p, q - 1);
            qs(q + 1, r);
        }
    }

    private int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        int t;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        t = a[r];
        a[r] = a[i + 1];
        a[i + 1] = t;

        System.out.println(i + 1);

        return i + 1;
    }

    public static void main(String[] args) {
        new QuickSort();
    }
}
