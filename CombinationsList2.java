package javaoop;

import java.util.Scanner;

public class CombinationsList2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        printCombinations(n, k);
        input.close();
    }

    static void printCombinations(int n, int k) {
        int counter = 0;
        int[] array = new int[n];
        int[] combination = new int[k];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        counter = recusion(array, combination, 0, n - 1, 0, k, counter);
        System.out.println("\nTong cong co " + counter + " to hop");
    }

    static int recusion(int[] array, int[] combination, int start, int end, int index, int k, int counter) {
        if (index == k) {
            counter++;
            for (int i = 0; i < k; i++) {
                System.out.print(combination[i]);
            }
            System.out.print(" ");
            return counter;
        }
        for (int i = start; i <= end && end - i + 1 >= k - index; i++) {
            combination[index] = array[i];
            counter = recusion(array, combination, i + 1, end, index + 1, k, counter);
        }
        return counter;
    }
}
