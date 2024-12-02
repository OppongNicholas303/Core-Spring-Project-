package com.spring.lab.sort;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class BucketSort {

    public List<Integer> sort(List<Integer> list, String order) {
        if (list.isEmpty()) {
            return list;
        }

        int maxVal = Collections.max(list);
        int minVal = Collections.min(list);
        int bucketSize = Math.max(1, (maxVal - minVal) / list.size());
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        // Create buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Place elements in the appropriate bucket
        for (int num : list) {
            int bucketIndex = (num - minVal) / bucketSize;
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket and add elements back to the original list in the desired order
        list.clear();
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                if (order.equalsIgnoreCase("asc")) {
                    Collections.sort(bucket);
                } else {
                    bucket.sort(Comparator.reverseOrder());
                }
                list.addAll(bucket);
            }
        }

        return list;
    }
}