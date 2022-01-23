package javaoop;

import java.util.Scanner;

public class CatDoi {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String number = in.nextLine();
            System.out.println(cut(number.trim()));
        }

        System.out.println("Hello ban Oanh mat ngu hihi");
    }

    public static String cut(String number) {
        if (!number.matches("[0189]+")) {
            return "INVALID";
        }
        number = number.replaceAll("[089]", "0");
        number = number.replaceAll("[1]", "1");
        if (number.matches("[0]+")) {
            return "INVALID";
        }
        return number.replaceAll("(^[0]+)(?=[1-9]+)", "");
    }



}
