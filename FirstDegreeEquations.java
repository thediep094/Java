package javaoop;

import java.util.Scanner;

public class FirstDegreeEquations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float a = input.nextFloat();
        float b = input.nextFloat();
        solve(a, b);
        input.close();
    }

    static void solve(float a, float b) {
        if (a == 0 && b == 0) {
            System.out.println("VSN");
        } else if (a == 0) {
            System.out.print("VN");
        } else {
            float result = -b / a;
            System.out.printf("%.2f", result);
        }
    }
}
