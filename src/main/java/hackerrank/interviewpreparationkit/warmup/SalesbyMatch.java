package hackerrank.interviewpreparationkit.warmup;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalesbyMatch {

    static int sockMerchant(int n, int[] ar) {
        int pair = 0;
        Map<Integer, Integer> pairCounter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (pairCounter.containsKey(ar[i])) {
                pairCounter.put(ar[i], pairCounter.get(ar[i]) + 1);
                if (pairCounter.get(ar[i]) % 2 == 0) {
                    pair++;
                }
            } else {
                pairCounter.put(ar[i], 1);
            }
        }
        return pair;
    }



    public static void main(String[] args) {

    }

}
