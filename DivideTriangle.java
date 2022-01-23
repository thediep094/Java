package javaoop;

import java.util.Scanner;

public class DivideTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int h = input.nextInt();
            divide(n, h);
        } 
        input.close();
    }

    static void divide(int n, int h) {
        for (int i = 1; i < n; i++) {
            double distance = (double) Math.sqrt((double) i / n) * h;
            System.out.printf("%.6f ", distance);
        }
        System.out.println();
    }
}
