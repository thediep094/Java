package javaoop;

import java.util.HashMap;
import java.util.Scanner;

public class DienThoaiCucGach {
    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('A', 2);
        hm.put('B', 2);
        hm.put('C', 2);
        hm.put('D', 3);
        hm.put('E', 3);
        hm.put('F', 3);
        hm.put('G', 4);
        hm.put('H', 4);
        hm.put('I', 4);
        hm.put('J', 5);
        hm.put('K', 5);
        hm.put('L', 5);
        hm.put('M', 6);
        hm.put('N', 6);
        hm.put('O', 6);
        hm.put('P', 7);
        hm.put('Q', 7);
        hm.put('R', 7);
        hm.put('S', 7);
        hm.put('T', 8);
        hm.put('U', 8);
        hm.put('V', 8);
        hm.put('W', 9);
        hm.put('X', 9);
        hm.put('Y', 9);
        hm.put('Z', 9);

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String str = in.nextLine().trim().toUpperCase();
            System.out.println(isSymmetric(str, hm) ? "YES" : "NO");
        }
        in.close();
    }

    protected static Boolean isSymmetric(String str, HashMap<Character, Integer> hm) {
        for (int i = 0; i < (str.length() - 1) / 2 + 1; i++) {
            if (hm.get(str.charAt(i)) != hm.get(str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
