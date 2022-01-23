package javaoop;

import java.util.HashMap;
import java.util.Scanner;

public class CountPairsWithSumGivenK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long t = input.nextLong();
        while (t-- > 0) {
            int n = input.nextInt();
            long k = input.nextLong();
            long[] array = new long[n];
            HashMap<Long, Long> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                array[i] = input.nextLong();
                if (!hm.containsKey(array[i]))
                    hm.put(array[i], (long) 0);
                hm.put(array[i], hm.get(array[i]) + 1);
            }
            System.out.println(getPairsCount(hm, array, n, k));
        }
        input.close();
    }

    static long getPairsCount(HashMap<Long, Long> hm, long arr[], long n, long sum) {
        long twice_count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);
            if (sum - arr[i] == arr[i])
                twice_count--;
        }
        return twice_count / 2;
    }
}
