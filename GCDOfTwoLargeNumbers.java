package javaoop;

import java.util.Scanner;

public class GCDOfTwoLargeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            long a = input.nextLong();
            input.nextLine();
            long b = reduceLargeNumber(a, input.nextLine().trim());
            System.out.println(GCD(a, b));
        }
        input.close();
    }

    static protected long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    static protected long reduceLargeNumber(long a, String b) {
        long result = 0;
        for (int i = 0; i < b.length(); i++) {
            result = (result * 10 + (b.charAt(i) - '0')) % a;
        }
        return result;
    }
}
