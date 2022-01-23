package javaoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Remove100InBinaryString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String s = input.next();
            List<Pair<Character, Integer>> st = new ArrayList<>();
            int max = 0;
            st.add(new Pair<Character, Integer>('@', -1));
            for (int i = 0; i < s.length(); i++) {
                Character item = s.charAt(i);
                st.add(new Pair<Character, Integer>(item, i));
                while (st.size() >= 3 && st.get(st.size() - 1).first == '0' && st.get(st.size() - 2).first == '0'
                        && st.get(st.size() - 3).first == '1') {
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                    st.remove(st.size() - 1);
                }
                int tmp = st.get(st.size() - 1).second;
                max = max > i - tmp ? max : i - tmp;
            }
            System.out.println(max);
        }
        input.close();
    }
}

class Pair<T1, T2> {
    public Pair(T1 f, T2 s) {
        this.first = f;
        this.second = s;
    }

    public T1 first;
    public T2 second;
}
