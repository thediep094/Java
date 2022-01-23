/**
 * @author: khacdatdo
 * @website: khacdatdo.dev
 */
package javaoop;

import java.util.Scanner;

public class FindNthFibonacci {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int t = Input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = Input.nextInt();
            System.out.println(findNth(n));
        }
        Input.close();
    }

    static long findNth(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long a = 1;
        long b = 1;
        long c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
