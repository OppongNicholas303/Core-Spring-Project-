package com.spring.lab.sort;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RadixSort {

    public List<Integer> sort(List<Integer> list, String order) {
        if (list.isEmpty()) {
            return list;
        }
        int max = getMax(list);
        int exp = 1;

        // Sort for each digit place
        while (max / exp > 0) {
            countSort(list, exp, order);
            exp *= 10;
        }

        if (order.equalsIgnoreCase("desc")) {
            Collections.reverse(list);
        }

        return list;
    }

    private void countSort(List<Integer> list, int exp, String order) {
        int n = list.size();
        int[] count = new int[10];
        int[] output = new int[n]; // Use an array for output

        // Initialize count array
        for (int i = 0; i < n; i++) {
            int digit = (list.get(i) / exp) % 10;
            count[digit]++;
        }

        // Update count array for cumulative frequency
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array using the count array
        for (int i = n - 1; i >= 0; i--) {
            int num = list.get(i);
            int digit = (num / exp) % 10;
            output[count[digit] - 1] = num;
            count[digit]--;
        }

        // Copy the output array back to the original list
        for (int i = 0; i < n; i++) {
            list.set(i, output[i]);
        }
    }

    private int getMax(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}