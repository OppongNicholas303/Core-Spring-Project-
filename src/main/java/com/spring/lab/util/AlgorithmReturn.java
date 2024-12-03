package com.spring.lab.util;

import com.spring.lab.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlgorithmReturn {
    private SortingService sortingService;

    @Autowired
    public AlgorithmReturn(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    public String algorithm(String input, String order, String algorithm) {

        switch (algorithm) {
            case "heap-sort":
                return sortingService.heapSortService(input, order);
            case "quick":
                return sortingService.quickSortService(input, order);
            case "merge":
                    return sortingService.mergeSortService(input, order);
            case "bucket":
                return sortingService.bucketSortService(input, order);
            case "radix":
                return sortingService.radixSortService(input, order);
            default:
                return null;
        }

    }
}
