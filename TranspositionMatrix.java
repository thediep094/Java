package javaoop;

import java.util.Scanner;

public class TranspositionMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int test = 0; test < t; test++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] array = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = input.nextInt();
                }
            }
            int[][] result = multiply(array);
            System.out.println("Test " + (test + 1) + ": ");
            show(result);
        }
        input.close();
    }

    static int[][] multiply(int[][] array) {
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int sum = 0;
                for (int k = 0; k < array[j].length; k++) {
                    sum += array[i][k] * array[j][k];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    static void show(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
