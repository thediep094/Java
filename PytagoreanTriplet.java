package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PytagoreanTriplet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            ArrayList<Long> list = new ArrayList<>();
            while (n-- > 0) {
                list.add(input.nextLong());
            }
            System.out.println(hasThreePytagoNumbers(list) ? "YES" : "NO");
        }
        input.close();
    }

    static boolean hasThreePytagoNumbers(ArrayList<Long> array) {
        for (int i = 0; i < array.size(); i++) {
            array.set(i, (long) Math.pow(array.get(i), 2));
        }
        Collections.sort(array);
        for (int i = array.size() - 1; i >= 2; i--) {
            int b = 0;
            int c = i - 1;
            while (b < c) {
                if (array.get(b) + array.get(c) == array.get(i)) {
                    return true;
                }
                if (array.get(b) + array.get(c) > array.get(i)) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return false;
    }
}
