package javaoop;

import java.util.Scanner;

public class EgdesList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = input.nextInt();
            }
        }
        input.close();
        show(array);
    }

    static void show(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                if (array[i][j] == 1 && array[j][i] == 1) {
                    System.out.println("(" + (i + 1) + "," + (j + 1) + ")");
                }
            }
        }
    }
}
