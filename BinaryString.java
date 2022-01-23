package javaoop;

import java.util.Scanner;

public class BinaryString {
    static Scanner input;

    static long[] fibo;

    static char fibonacci(int n, Long k) {
        if (n == 1)
            return '0';
        if (n == 2)
            return '1';
        if (k <= fibo[n - 2])
            return fibonacci(n - 2, k);
        return fibonacci(n - 1, k - fibo[n - 2]);
    }

    public static void main(String[] args) throws Exception {
        input = new Scanner(System.in);
        fibo = new long[200];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            long k = input.nextLong();
            System.out.println(fibonacci(n, k));
        }
    }
}
