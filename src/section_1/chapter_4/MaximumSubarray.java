package section_1.chapter_4;

public class MaximumSubarray {
    private int[] a;

    public MaximumSubarray(int[] a) {
        this.a = a;

        int[] x = findMaximumSubarray(a, 0, a.length - 1);

        for (int i : x) System.out.print(i + "\t");
    }

    private int[] maxCrossingSubarray(int[] a, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE, right_sum = Integer.MIN_VALUE;
        int max_left = 0, max_right = 0;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        return new int[]{max_left, max_right, left_sum + right_sum};
    }

    private int[] findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) return new int[]{low, high, a[low]};
        else {
            int mid = (low + high) / 2;
            int[] left = findMaximumSubarray(a, low, mid);
            int[] right = findMaximumSubarray(a, mid + 1, high);
            int[] cross = maxCrossingSubarray(a, low, mid, high);
            if (left[2] >= right[2] && left[2] >= cross[2]) return left;
            else if (right[2] >= left[2] && right[2] >= cross[2]) return right;
            else return cross;
        }
    }

    public static void main(String[] args) {
        new MaximumSubarray(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
    }
}