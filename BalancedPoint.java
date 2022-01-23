package javaoop;

import java.util.Scanner;

public class BalancedPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] array = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (input.hasNext()) {
                    array[i] = input.nextInt();
                    sum += array[i];
                }
            }
            System.out.println(find(array, sum));
        }
        input.close();
    }

    static int find(int[] array, long sum) {
        float haft_sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (haft_sum == (float) (sum - array[i]) / 2) {
                return i + 1;
            }
            haft_sum += array[i];
        }
        return -1;
    }
}
