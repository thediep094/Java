package javaoop;

import java.util.ArrayList;
import java.util.Scanner;

public class ThuGonDaySo {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        ArrayList<Integer> stack = new ArrayList<>();
        while (n-- > 0) {
            int temp = in.nextInt();
            if (stack.size() == 0) {
                stack.add(temp);
            } else {
                if ((temp + stack.get(stack.size() - 1)) % 2 == 0) {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(temp);
                }
            }
        }
        System.out.println(stack.size());
    }
}
