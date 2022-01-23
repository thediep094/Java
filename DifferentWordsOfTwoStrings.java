package javaoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DifferentWordsOfTwoStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String a = input.nextLine();
            String b = input.nextLine();
            ArrayList<String> words = findDiff(a, b);
            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
        input.close();
    }

    static ArrayList<String> findDiff(String a, String b) {
        ArrayList<String> lists = new ArrayList<String>();
        String[] words = a.trim().replaceAll("( )+", " ").split(" ");
        Arrays.sort(words);
        for (String word : words) {
            if (!lists.contains(word) && b.indexOf(word) == -1) {
                lists.add(word);
            }
        }
        return lists;        
    }
}
