package javaoop;

import java.util.Scanner;

public class CandicatesClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fullname = input.nextLine().trim();
        String birthday = input.nextLine().trim();
        float sum_score = 0;
        int t = 3;
        while (t-- > 0) {
            sum_score += input.nextFloat();
        }
        input.close();
        System.out.print(fullname + " " + birthday + " ");
        System.out.printf("%.1f", sum_score);
    }
}
