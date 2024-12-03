package com.spring.lab.sort;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuickSort {

    public List<Integer> sort(List<Integer> list, String order) {
        quickSort(list, 0, list.size() - 1, order);
        return list;
    }

    private void quickSort(List<Integer> list, int low, int high, String order) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, order);
            quickSort(list, low, pivotIndex - 1, order);
            quickSort(list, pivotIndex + 1, high, order);
        }
    }

    private int partition(List<Integer> list, int low, int high, String order) {
        int pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (order.equalsIgnoreCase("asc")) {
                if (list.get(j) < pivot) {
                    i++;
                    swap(list, i, j);
                }
            } else {
                if (list.get(j) > pivot) {
                    i++;
                    swap(list, i, j);
                }
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}