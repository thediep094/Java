package javaoop;

import java.util.Scanner;

public class ShortenString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next().trim();
        String stack = "";
        for (int i = 0; i < str.length(); i++) {
            if (stack.length() == 0) {
                stack += str.charAt(i);
            } else if (stack.charAt(stack.length() - 1) == str.charAt(i)) {
                stack = stack.substring(0, stack.length() - 1);
            } else {
                stack += str.charAt(i);
            }
        }
        System.out.print(stack.length() > 0 ? stack : "Empty String");
        input.close();
    }
}
