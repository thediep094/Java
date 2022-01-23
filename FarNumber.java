package javaoop;

import java.util.Scanner;

public class FarNumber {
    // public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);
    // int t = input.nextInt();
    // while (t-- > 0) {
    // int n = input.nextInt();
    // int[] array = new int[n];
    // for (int i = 0; i < n; i++) {
    // array[i] = i + 1;
    // }
    // permute(array, 0, n - 1);
    // System.out.println();
    // }
    // input.close();
    // }

    // static void permute(int[] array, int l, int r) {
    // if (l == r) {
    // if (isOK(array)) {
    // for (int i = 0; i < array.length; i++) {
    // System.out.print(array[i]);
    // }
    // System.out.println("");
    // }
    // } else {
    // for (int i = l; i <= r; i++) {
    // array = swap(array, l, i);
    // permute(array, l + 1, r);
    // array = swap(array, l, i);
    // }
    // }
    // }

    // static int[] swap(int[] a, int i, int j) {
    // int temp = a[i];
    // a[i] = a[j];
    // a[j] = temp;
    // return a;
    // }

    // static boolean isOK(int[] number) {
    // for (int i = 0; i < number.length - 1; i++) {
    // if (number[i + 1] - number[i] == 1) {
    // return false;
    // }
    // }
    // return true;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = i;
            boolean ok = true;
            while (ok) {
                int check = 1;
                for (int i = 1; i < n; i++) {
                    if (Math.abs(a[i] - a[i + 1]) == 1)
                        check = 0;
                }
                if (check == 1) {
                    for (int i = 1; i <= n; i++)
                        System.out.print(a[i]);
                    System.out.println("");
                }
                int j = n - 1;
                while (j > 0 && a[j] > a[j + 1])
                    j--;
                if (j == 0)
                    ok = false;
                else {
                    int k = n;
                    while (a[k] < a[j])
                        k--;
                    int tmp = a[j];
                    a[j] = a[k];
                    a[k] = tmp;
                    int l = j + 1;
                    int r = n;
                    while (l <= r) {
                        int x = a[l];
                        a[l] = a[r];
                        a[r] = x;
                        l++;
                        r--;
                    }
                }
            }
        }
        sc.close();
    }
}
