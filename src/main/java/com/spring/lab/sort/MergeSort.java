package com.spring.lab.sort;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MergeSort {

    public List<Integer> sort(List<Integer> list, String order) {
        mergeSort(list, 0, list.size() - 1, order);
        return list;
    }

    private void mergeSort(List<Integer> list, int left, int right, String order) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid, order);
            mergeSort(list, mid + 1, right, order);
            merge(list, left, mid, right, order);
        }
    }

    private void merge(List<Integer> list, int left, int mid, int right, String order) {
        List<Integer> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<Integer> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (order.equalsIgnoreCase("asc")) {
                if (leftList.get(i) <= rightList.get(j)) {
                    list.set(k++, leftList.get(i++));
                } else {
                    list.set(k++, rightList.get(j++));
                }
            } else {
                if (leftList.get(i) >= rightList.get(j)) {
                    list.set(k++, leftList.get(i++));
                } else {
                    list.set(k++, rightList.get(j++));
                }
            }
        }

        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }

        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }
}