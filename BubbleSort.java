package javaoop;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        input.close();
        sort(array);
    }

    static void sort(int[] array) {
        for (int step = 0; step < array.length; step++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            System.out.print("Buoc " + (step + 1) + ": ");
            show(array);
            System.out.println();
            if (check(array)) {
                break;
            }
        }
    }

    static void show(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
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
