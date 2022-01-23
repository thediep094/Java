package javaoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortingTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        TimeList list = new TimeList();
        while (n-- > 0) {
            list.add(input.nextLine().trim());
        }
        list.sort();
        list.show();
        input.close();
    }
}

class TimeList {
    private ArrayList<String> list;

    TimeList() {
        this.list = new ArrayList<>();
    }

    protected void add(String t) {
        this.list.add(t);
    }

    protected void sort() {
        Collections.sort(this.list, new Comparator<String>() {
            public int compare(String a, String b) {
                String[] strA = a.split("\\s+");
                String[] strB = b.split("\\s+");
                int tempA = Integer.valueOf(strA[0]) * 3600 + Integer.valueOf(strA[1]) * 60 + Integer.valueOf(strA[2]);
                int tempB = Integer.valueOf(strB[0]) * 3600 + Integer.valueOf(strB[1]) * 60 + Integer.valueOf(strB[2]);
                return tempA - tempB;
            }
        });
    }

    protected void show() {
        for (String t : this.list) {
            System.out.println(t);
        }
    }
}