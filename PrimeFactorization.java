/**
 *  Don't copy completely, do your best first!
 */
package javaoop;

import java.util.Scanner;

/**
 * @author: khacdatdo
 */

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            System.out.print("Test " + (i + 1) + ": ");
            factory(n);
            System.out.println("");
        }
        input.close();
    }

    static void factory(int n) {
        int dem = 0;
        while (n % 2 == 0) {
            dem++;
            n >>= 1;
        }
        if (dem > 0) {
            System.out.print("2(" + dem + ") ");
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            dem = 0;
            while (n % i == 0) {
                dem++;
                n /= i;
            }
            if (dem > 0) {
                System.out.print(i + "(" + dem + ") ");
            }
        }
        if (n > 2) {
            System.out.print(n + "(1) ");
        }
    }

}
