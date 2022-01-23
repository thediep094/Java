package javaoop;

import java.util.Scanner;

public class DirectionSortReversingList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = input.nextInt();
            }
            // sort
            String result = "";
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (array[i] > array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
                result = "Buoc " + (i + 1) + ": " + show(array) + "\n" + result;
            }
            System.out.print(result);
        }
        input.close();
    }

    static String show(int[] array) {
        String result = "";
        for (int i : array) {
            result += i + " ";
        }
        return result;
    }
}
