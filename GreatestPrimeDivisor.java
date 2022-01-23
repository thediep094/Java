/**
 *  Don't copy completely, do your best first!
 */
package javaoop;

import java.util.Scanner;

/**
 *
 * @author khacdatdo
 */
public class GreatestPrimeDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            long n = input.nextLong();
            System.out.println(getGreatestPrimeDivisor(n));
        }
        input.close();
    }
    
    static long getGreatestPrimeDivisor(long n) {
        long max = 2;
        while (n % 2 == 0) {
            max = Math.max(max, 2);
            n >>= 1;
        }
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                max = Math.max(i, max);
                n /= i;
            }
        }
        if (n > 2) {
            max = Math.max(max, n);
        }
        return max;
    }
}
