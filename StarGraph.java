package javaoop;

import java.util.HashMap;
import java.util.Scanner;

public class StarGraph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int counter = 0;
        while (input.hasNextInt()) {
            int temp = input.nextInt();
            if (hm.get(temp) == null) {
                hm.put(temp, 1);
            } else {
                if (hm.get(temp) == 1) {
                    counter++;
                }
                hm.replace(temp, hm.get(temp) + 1);
            }
        }
        System.out.print(counter == 1 ? "Yes" : "No");
        input.close();
    }

    static boolean isStar(int[] array) {

        return true;
    }
}
