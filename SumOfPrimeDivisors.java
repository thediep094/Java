/**
 * Don't copy completely, do your best first!
 */
package javaoop;

import java.util.Scanner;

/**
 *
 * @author khacdatdo
 */
public class SumOfPrimeDivisors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long sum = 0;
        int[] sieve_array = sieve();
        while (n-- > 0) {
            int x = input.nextInt();
            while (x != 1) {
                sum += sieve_array[x];
                x /= sieve_array[x];
            }
        }
        System.out.print(sum);
        input.close();
    }

    static int[] sieve() {
        int max = 2 * (int) Math.pow(10, 6) + 1;
        int[] array = new int[max];
        array[1] = 1;
        for (int i = 2; i < max; i++) {
            array[i] = i % 2 == 0 ? 2 : i;
        }
        for (int i = 3; i * i < max; i++) {
            if (array[i] == i) {
                for (int j = i * i; j < max; j += i) {
                    if (array[j] == j) {
                        array[j] = i;
                    }
                }
            }
        }
        return array;
    }
}
