package section_1.chapter_8;

public class CountingSort {
    private int[] a;
    private int[] b;
    private int[] c;

    private CountingSort(int[] a) {
        this.a = a;
        this.b = new int[a.length];
        this.c = new int[getMax()];

        for (int x: a) c[x - 1]++;
        for (int i = 1; i < c.length; i++) c[i] += c[i - 1];
        for (int i = 0; i < a.length; i++) {

        }
    }

    private int getMax() {
        int max = 0;
        for (int x : this.a) if (x > max) max = x;
        return max;
    }

    public static void main(String[] args) {
        new CountingSort(new int[]{2, 5, 3, 0, 2, 3, 0, 3});
    }
}
