package javaoop;

import java.util.Scanner;

public class BubbleSortReversingList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = input.nextInt();
            }
            System.out.print(sort(array));
        }
        input.close();
    }

    static String sort(int[] array) {
        String result = "";
        for (int step = 0; step < array.length; step++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            result = "Buoc " + (step + 1) + ": " + show(array) + "\n" + result;
            if (check(array)) {
                break;
            }
        }
        return result;
    }

    static String show(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i] + " ";
        }
        return result;
    }

    static boolean check(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
