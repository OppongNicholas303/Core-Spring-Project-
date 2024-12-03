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

        //Convert the input string into int array
        List<Integer> convertedToInt    = inputToArray.toIntArray(input);
        List<Integer> sortedList = heapSort.sort(convertedToInt, order);
        return sortedList.toString();
    }

    public String quickSortService(String input, String order) {

        //Convert the input string into int array
        List<Integer> convertedToInt    = inputToArray.toIntArray(input);
        List<Integer> sortedList = quickSort.sort(convertedToInt, order);
        return sortedList.toString();
    }

    public String mergeSortService(String input, String order) {

        //Convert the input string into int array
        List<Integer> convertedToInt    = inputToArray.toIntArray(input);
        List<Integer> sortedList = mergeSort.sort(convertedToInt, order);
        return sortedList.toString();
    }

    public String bucketSortService(String input, String order) {

        //Convert the input string into int array
        List<Integer> convertedToInt    = inputToArray.toIntArray(input);
        List<Integer> sortedList = bucketSort.sort(convertedToInt, order);
        return sortedList.toString();
    }

    public String radixSortService(String input, String order) {

        //Convert the input string into int array
        List<Integer> convertedToInt    = inputToArray.toIntArray(input);
        List<Integer> sortedList = radixSort.sort(convertedToInt, order);
        return sortedList.toString();
    }
}
