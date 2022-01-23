/**
 *  Don't copy completely, do your best first!
 */
package javaoop;

import java.util.Scanner;

/**
 *
 * @author khacdatdo
 */
public class CountDivisorDiv2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            System.out.println(count(n));
        }
        input.close();
    }

    static int count(int n) {
        int counter = 0;
        for (int i = 2; i * i < n; i += 2) {
            if (n % i == 0 && i % 2 == 0) {
                counter++;
            }
        }
        for (int i = (int) Math.sqrt(n);
                i >= 1; i--) {
            if (n % i == 0 && (n / i) % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }
}
