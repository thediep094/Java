package javaoop;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SubsequencesWithPrimeSum {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] f = new int[n];
            Arrays.sort(a, Collections.reverseOrder());
            Try(a, n, f, 0);
        }
    }

    static void Try(Integer[] a, int n, int[] f, int i) {
        for (int j = 0; j <= 1; j++) {
            f[i] = j;
            if (i == n - 1) {
                int tong = 0;
                for (int k = 0; k < n; k++) {
                    tong += f[k] * a[k];
                }
                if (isPrime(tong)) {
                    for (int k = 0; k < n; k++) {
                        if (f[k] == 1) {
                            System.out.print(a[k] + " ");
                        }
                    }
                    System.out.println("");
                }
            } else
                Try(a, n, f, i + 1);
        }
    }

    static boolean isPrime(int n) {
        if (n < 4) {
            return n > 1;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
