package com.spring.lab.service;

import com.spring.lab.sort.*;
import com.spring.lab.util.InputToArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SortingService {

    private HeapSort heapSort;
    private QuickSort quickSort;
    private MergeSort mergeSort;
    private BucketSort bucketSort;
    private RadixSort radixSort;
    private InputToArray inputToArray;

    @Autowired
    public SortingService(
            QuickSort quickSort,
            MergeSort mergeSort,
            BucketSort bucketSort,
            RadixSort radixSort,
            HeapSort heapSort,
            InputToArray inputToArray
    )
    {
        this.heapSort = heapSort;
        this.quickSort = quickSort;
        this.mergeSort = mergeSort;
        this.bucketSort = bucketSort;
        this.radixSort = radixSort;
        this.inputToArray = inputToArray;

    }

    public String heapSortService(String input, String order) {

        System.out.println(input);

        String [] split = input.split(",");

        List<Integer> intArray = new ArrayList<>();

        for(int i = 0; i < split.length; i++) {
            intArray.add(Integer.parseInt(split[i].trim()));
        }

        List<Integer> sortedList = heapSort.sort(intArray, order);

        System.out.println("sort " +sortedList.toString());

        return sortedList.toString();
    }

    public String quickSortService(String input, String order) {
        String[] split = input.split(",");
        List<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            intArray.add(Integer.parseInt(split[i].trim()));
        }

        List<Integer> sortedList = quickSort.sort(intArray, order);
        return sortedList.toString();
    }

    public String mergeSortService(String input, String order) {
        String[] split = input.split(",");
        List<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            intArray.add(Integer.parseInt(split[i]));
        }

        List<Integer> sortedList = mergeSort.sort(intArray, order);
        return sortedList.toString();
    }

    public String bucketSortService(String input, String order) {
        String[] split = input.split(",");
        List<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            intArray.add(Integer.parseInt(split[i]));
        }
        List<Integer> convertedToInt    = inputToArray.toIntArray(input);
        List<Integer> sortedList = bucketSort.sort(convertedToInt, order);
        return sortedList.toString();
    }

    public String radixSortService(String input, String order) {
        String[] split = input.split(",");
        List<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            intArray.add(Integer.parseInt(split[i]));
        }
        System.out.println("sortRadix " +intArray.toString());
        List<Integer> sortedList = radixSort.sort(intArray, order);
        return sortedList.toString();
    }
}
