package javaoop;

import java.util.Scanner;

public class NormalizeName2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String name = input.nextLine();
            System.out.println(normalize(name));
        }
        input.close();
    }

    static String normalize(String name) {
        name = name.toLowerCase().trim().replaceAll("( )+", " ");
        String[] array_words = name.split(" ");
        String result = "";
        for (int i = 1; i < array_words.length; i++) {
            result += array_words[i].toUpperCase().charAt(0) + (array_words[i].length() > 1 ? array_words[i].toLowerCase().substring(1) : "") + " ";
        }
        return result.trim() + ", " + array_words[0].toUpperCase();
    }
}
