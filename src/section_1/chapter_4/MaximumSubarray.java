package section_1.chapter_4;

public class MaximumSubarray {
    public MaximumSubarray() {

    }

    private int[] maxCrossingSubarray(int[] a, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE, right_sum = Integer.MIN_VALUE;
        int max_left = 0, max_right = 0;
        int sum = 0;
        for (int i = mid; i <= low; i++) {
            sum += a[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            } else break;
        }
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            } else break;
        }
        return new int[]{max_left, max_right, left_sum + right_sum};
    }

    private int[] findMaxiumSubarray(int[] a, int low, int high) {
        if (low == high) return new int[]{low, high, a[low]};
        else {
            int[]
        }
    }

    public static void main(String[] args) {

    }
}
