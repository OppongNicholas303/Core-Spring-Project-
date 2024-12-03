package com.spring.lab.sort;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSort {
    public List<Integer> sort(List<Integer> arr, String order) {
        int n = arr.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, order);

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            heapify(arr, i, 0, order);
        }
        return arr;
    }

    private void heapify(List<Integer> arr, int n, int i, String order) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        switch (order){
            case "asc":
                if (left < n && arr.get(left) > arr.get(largest))
                    largest = left;

                if (right < n && arr.get(right) > arr.get(largest))
                    largest = right;

                if (largest != i) {
                    int swap = arr.get(i);
                    arr.set(i, arr.get(largest));
                    arr.set(largest, swap);

                    heapify(arr, n, largest, order);
                }
                break;
                case "desc":
                    if (left < n && arr.get(left) < arr.get(largest))
                        largest = left;

                    if (right < n && arr.get(right) < arr.get(largest))
                        largest = right;

                    if (largest != i) {
                        int swap = arr.get(i);
                        arr.set(i, arr.get(largest));
                        arr.set(largest, swap);

                        heapify(arr, n, largest, order);
                    }
            default:
                break;
        }

    }
}

