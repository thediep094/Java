package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DaoDau {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size() && k > 0; i++) {
            if (arr.get(i) < 0) {
                arr.set(i, arr.get(i) * -1);
                k--;
            } else {
                break;
            }
        }

        Collections.sort(arr);

        if (k > 0 && k % 2 == 1) {
            arr.set(0, arr.get(0) * -1);
        }

        long sum = 0;
        for (Integer number : arr) {
            sum += number;
        }
        System.out.println(sum);
    }

}
