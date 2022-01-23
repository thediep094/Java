package javaoop;

import java.util.Scanner;

public class SelectionSortReverseList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        // sort
        String result = "";
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            result = "Buoc " + (i + 1) + ": " + show(array) + "\n" + result;
        }
        System.out.print(result);
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
