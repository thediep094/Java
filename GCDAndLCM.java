/**
 *  Don't copy completely, do your best first!
 */
package javaoop;

import java.util.Scanner;

/**
 *
 * @author khacdatdo
 */
public class GCDAndLCM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long t = input.nextInt();
        while (t-- > 0) {
            long a = input.nextLong();
            long b = input.nextLong();
            System.out.println(LCM(a, b) + " " + GCD(a, b));
        }
        input.close();
    }

    static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
    
    static long LCM(long a, long b) {
        return (a * b) / GCD(a, b);
    }
}
