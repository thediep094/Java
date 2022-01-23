package javaoop;

import java.util.Scanner;

public class FindMod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            String number = input.next().trim();
            System.out.println(mod(number) == 0 ? 4 : 0);
        }
        input.close();
    }

    static int mod(String number) {
        int mod = 0;
        for (int i = 0; i < number.length(); i++) {
            mod = ((mod * 10) + (number.charAt(i) - '0')) % 4;
        }
        return mod;
    }
}
