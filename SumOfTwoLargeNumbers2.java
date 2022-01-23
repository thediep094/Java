package javaoop;

import java.util.Scanner;

public class SumOfTwoLargeNumbers2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next().trim();
        String b = input.next().trim();
        System.out.println(findSum(a, b));
        input.close();
    }

    static String findSum(String a, String b) {
        String large = "", small = "";
        if (a.length() > b.length()) {
            large = a;
            small = b;
        } else if (b.length() > a.length()) {
            large = b;
            small = a;
        } else {
            large = a;
            small = b;
        }
        large = reverseString(large);
        small = reverseString(small);
        String result = "";
        int x = 0;
        for (int i = 0; i < large.length(); i++) {
            int temp = (int) ((large.charAt(i) - '0') + (i < small.length() ? small.charAt(i) - '0' : 0)) + x;
            x = temp / 10;
            result += temp % 10;
        }
        if (x > 0) {
            result += x;
        }
        return removeZero(reverseString(result));
    }

    static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    static String removeZero(String number) {
        int i = 0;
        while (i < number.length() - 1 && number.charAt(i) == '0') {
            i++;
        }
        return number.substring(i);
    }
}
