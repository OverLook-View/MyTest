package com.study.demo.sort;

import java.util.ArrayList;

public class RadixSort {
    public static void radixSortA(String[] arr, int stringLen) {
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }
            int idx = 0;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket) {
                    arr[idx++] = s;
                }
                thisBucket.clear();
            }
        }
    }

    public static void countingRadixSort(String[] arr, int stringLen) {
        final int BUCKETS = 256;

        int N = arr.length;
        String[] buffer = new String[N];

        String[] in = arr;
        String[] out = buffer;

        for (int pos = stringLen - 1; pos >= 0; pos--) {
            int[] count = new int[BUCKETS + 1];

            for (int i = 0; i < N; i++) {
                count[in[i].charAt(pos)]++;
            }
            for (int b = 1; b <= BUCKETS; b++) {
                count[b] += count[b - 1];
            }
            for (int i = 0; i < N; i++) {
                out[count[in[i].charAt(pos)]++] = in[i];
            }
            String[] tmp = in;
            in = out;
            out = tmp;
        }

        if (stringLen % 2 == 1) {
            for (int i = 0; i < arr.length; i++) {
                out[i] = in[i];
            }
        }
    }
}
