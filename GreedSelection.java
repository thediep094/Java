package javaoop;

import java.util.Scanner;

public class GreedSelection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int s = input.nextInt();
        System.out.println(findSmallest(n, s) + " " + findLargest(n, s));
        input.close();
    }

    static String findSmallest(int n, int s) {
        if (s == 0) {
            return n == 1 ? "0" : "-1";
        }
        s -= 1;
        String result = "";
        if (s > 9 * n) {
            result = "-1";
        } else {
            for (int i = 1; i < n; i++) {
                if (s > 9) {
                    result = "9" + result;
                    s -= 9;
                } else {
                    result = String.valueOf(s) + result;
                    s = 0;
                }
            }
            result = String.valueOf(s + 1) + result;
        }
        return result;
    }

    static String findLargest(int n, int s) {
        String result = "";
        if (s == 0) {
            return n == 1 ? "0" : "-1";
        }
        if (s > 9 * n) {
            result = "-1";
        } else {
            for (int i = 0; i < n; i++) {
                if (s > 9) {
                    result += String.valueOf(9);
                    s -= 9;
                } else {
                    result += String.valueOf(s);
                    s = 0;
                }
            }
        }
        return result;
    }
}
