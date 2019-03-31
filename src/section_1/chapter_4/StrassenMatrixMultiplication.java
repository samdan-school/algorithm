package section_1.chapter_4;

public class StrassenMatrixMultiplication {

    private StrassenMatrixMultiplication() {
        int[][] a = new int[][]{{1, 3}, {7, 5}};
        int[][] b = new int[][]{{6, 8}, {4, 2}};
        int[][] c = SquareMatrixMultiplication(new int[]{a.length, 0, 0, 0, 0}, a, b);

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
        int[] pa contains
            0th - a, bs' length
            1st - a's start horizontal value
            2nd - a's start vertical value
            3rd - b's start horizontal value
            4th - b's start vertical value
     */
    private int[][] SquareMatrixMultiplication(int[] p, int[][] a, int[][] b) {
        int n = p[0];
        if (n == 1) return new int[][]{{a[p[1]][p[2]] * b[p[3]][p[4]]}};
        else {
            int[][] c = new int[n][n];
            int m = n / 2;

            matrixAdd(
                    new int[]{0, 0},
                    c,
                    SquareMatrixMultiplication(new int[]{m, 0, 0, 0, 0}, a, b),
                    SquareMatrixMultiplication(new int[]{m, 0, m, m, 0}, a, b)
            );

            matrixAdd(
                    new int[]{0, m},
                    c,
                    SquareMatrixMultiplication(new int[]{m, 0, 0, 0, m}, a, b),
                    SquareMatrixMultiplication(new int[]{m, 0, m, m, m}, a, b)
            );

            matrixAdd(
                    new int[]{m, 0},
                    c,
                    SquareMatrixMultiplication(new int[]{m, m, 0, 0, 0}, a, b),
                    SquareMatrixMultiplication(new int[]{m, m, m, m, 0}, a, b)
            );

            matrixAdd(
                    new int[]{m, m},
                    c,
                    SquareMatrixMultiplication(new int[]{m, m, 0, 0, m}, a, b),
                    SquareMatrixMultiplication(new int[]{m, m, m, m, m}, a, b)
            );

            return c;
        }
    }

    private void matrixAdd(int[] p, int[][] c, int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++) c[i + p[0]][j + p[1]] = a[i][j] + b[i][j];
    }

    public static void main(String[] args) {
        new StrassenMatrixMultiplication();
    }
}