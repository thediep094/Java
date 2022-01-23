package javaoop;

import java.util.Scanner;

public class SumOf1ToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            long n = input.nextLong();
            System.out.println(sum(n));
        }
        input.close();
    }

    static long sum(long n) {
        return (n * (1 + n)) / 2;
    }
}
