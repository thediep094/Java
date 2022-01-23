
package javaoop;

import java.util.Arrays;
import java.util.Scanner;

public class SymmetricalArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long t = input.nextLong();
        for (long i = 0; i < t; i++) {
            int n = input.nextInt();
            long[] array = new long[n];
            for (int j = 0; j < n; j++) {
                if (input.hasNext()) {
                    array[j] = input.nextLong();
                }
            }
            String result = isSymmetricalArray(array) ? "YES" : "NO";
            System.out.println(Arrays.toString(array));
            System.out.println(result);
        }
        input.close();
    }

    static boolean isSymmetricalArray(long[] array) {
        for (int i = 0; i <= array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
