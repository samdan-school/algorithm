package special;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SpBinarySearch {
    private int[] a;

    private SpBinarySearch(File file) {
        writeFile(file);
        readFile(file);
        for (int i = 0; i < a.length; i++) System.out.printf("%2d-", i);
        System.out.println();
        for (int x : a) System.out.printf("%2d ", x);
        System.out.println();
        searchLastZero(a, 0, a.length - 1);
    }

    private void searchLastZero(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            if (a[q] == 0 && a[q + 1] == 1) {
                System.out.println("Last zero index: " + q);
                return;
            }
            if (a[q] == 1 && a[q - 1] == 0) {
                System.out.println("Last zero index: " + (q - 1));
                return;
            }

            if (a[q] == 0) {
                searchLastZero(a, q + 1, r);
            } else {
                searchLastZero(a, p, q - 1);
            }
        }
    }

    private void readFile(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            a = new int[scanner.nextInt()];
            int i = 0;
            while (scanner.hasNext()) {
                a[i] = scanner.nextInt();
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            int n = (int) Math.round(Math.random() * 100) + 1;
            int m = (int) Math.round(Math.random() * 100) + 1;

            writer.println(n + m);

            for (int i = 0; i < n; i++) writer.print(0 + " ");
            for (int i = 0; i < m; i++) writer.print(1 + " ");

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SpBinarySearch(new File("src/special/problem.txt"));
    }
}