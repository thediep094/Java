package javaoop;

import java.util.HashMap;
import java.util.Scanner;

public class EmailPTIT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> lists = new HashMap<String, Integer>();
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String name = input.nextLine();
            System.out.println(email(name, lists));
        }
        input.close();
    }

    static String email(String name, HashMap<String, Integer> lists) {
        name = name.toLowerCase().trim().replaceAll("( )+", " ");
        String[] array_words = name.split(" ");
        String result = array_words[array_words.length - 1];
        for (int i = 0; i < array_words.length - 1; i++) {
            result += array_words[i].charAt(0);
        }
        Integer temp = lists.get(result) == null ? 1 : lists.get(result) + 1;
        lists.put(result, temp);
        result += temp == 1 ? "" : temp.toString();
        return result.trim() + "@ptit.edu.vn";
    }
}
