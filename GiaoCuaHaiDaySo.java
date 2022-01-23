package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GiaoCuaHaiDaySo {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if (!arrA.contains(temp)) {
                arrA.add(temp);
            }
        }
        for (int i = 0; i < m; i++) {
            int temp = in.nextInt();
            if (!arrB.contains(temp)) {
                arrB.add(temp);
            }
        }

        Collections.sort(arrA);

        for (Integer number : arrA) {
            if (arrB.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
