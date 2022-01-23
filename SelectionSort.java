/**
 *  Don't copy completely, do your best first!
 */
package javaoop;

import java.util.Scanner;

/**
 * @author: khacdatdo
 */

public class SelectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        //  sort
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
            System.out.print("Buoc " + (i + 1) + ": ");
            show(array);
            System.out.println("");
        }
        input.close();
    }

    static void show(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
