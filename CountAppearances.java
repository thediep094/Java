/**
 *  Don't copy completely, do your best first!
 */
package javaoop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author khacdatdo
 */
public class CountAppearances {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int test = 0; test < t; test++) {
            int n = input.nextInt();
            ArrayList<Integer> array = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                array.add(input.nextInt());
            }
            System.out.println("Test " + (test + 1) + ":");
            count(array);
        }
        input.close();
    }

    static void count(ArrayList<Integer> array) {
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int x = 0; x < array.size(); x++) {
            Integer temp = hashmap.get(array.get(x).toString());
            hashmap.put(array.get(x).toString(), (temp == null) ? 1 : temp + 1);
            if (temp != null) {
                array.remove(x);
                x--;
            }
        }
        for (Integer x : array) {
            System.out.println(x + " xuat hien " + hashmap.get(x.toString()) + " lan");
        }
    }
}
