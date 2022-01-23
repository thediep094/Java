package javaoop;

import java.util.Scanner;

public class AdjacentsList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = input.nextInt();
            }
        }
        show(array);
        input.close();
    }

    static void show(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("List(%d) = ", i + 1);
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    System.out.print((j + 1) + " ");
                }
            }
            System.out.println();
        }
    }
}
