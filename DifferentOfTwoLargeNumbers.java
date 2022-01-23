package javaoop;

import java.util.Scanner;

public class DifferentOfTwoLargeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String a = input.next();
            String b = input.next();
            System.out.println(findDiff(a, b));
        }
        input.close();
    }

    static String findDiff(String a, String b) {
        String large = a, small = b;
        if (isSmaller(large, small)) {
            large = b;
            small = a;
        }

        large = reverseString(large);
        small = reverseString(small);
        String result = "";
        int x = 0;
        for (int i = 0; i < large.length(); i++) {
            int temp = (int) ((large.charAt(i) - '0') - (i < small.length() ? (small.charAt(i) - '0') : 0)) - x;
            if (temp < 0) {
                x = 1;
                temp += 10;
            } else {
                x = 0;
            }
            result += temp;
        }
        return reverseString(result);
    }

    static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    static boolean isSmaller(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 < n2)
            return true;
        if (n2 < n1)
            return false;

        for (int i = 0; i < n1; i++)
            if (str1.charAt(i) < str2.charAt(i))
                return true;
            else if (str1.charAt(i) > str2.charAt(i))
                return false;

        return false;
    }
}
