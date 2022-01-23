package javaoop;

import java.util.Scanner;

public class SymmetricalString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String string = input.next();
            System.out.println(isSymmetric(string.trim()) ? "YES" : "NO");
        }
        input.close();
    }

    static boolean isSymmetric(String string) {
        int counter = 0;
        for (int i = 0; i <= (string.length() - 1) / 2; i++) {
            if (counter > 1) {
                return false;
            }
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                counter++;
            }
        }
        return counter == 1 || counter == 0 && string.length() % 2 == 1;
    }
}
