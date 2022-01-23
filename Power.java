package javaoop;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        while (a != 0 || b != 0) {
            System.out.println(power(a, b));
            if (input.hasNext()) {
                a = input.nextLong();
                b = input.nextLong();
            }
        }
        input.close();
    }

    static long power(long a, long b) {
        long MOD = (long) 1e9 + 7;
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = result * a % MOD;
            }
            b /= 2;
            a = a * a % MOD;
        }
        return result;
    }
}
