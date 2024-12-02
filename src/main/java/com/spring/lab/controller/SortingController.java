package com.spring.lab.controller;

import com.spring.lab.DTO.SortDTO;
import com.spring.lab.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sort")
public class SortingController {
private SortingService sortingService;

    @Autowired
    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping("/")
    public String heapSort(
            @RequestBody SortDTO request
    ) {
        System.out.println("al " + request.algorithm());
//        return sortingService.heapSortService(request.array(), request.order()) ;
//        return sortingService.quickSortService(request.array(), request.order()) ;
//        return sortingService.mergeSortService(request.array(), request.order()) ;
        return sortingService.bucketSortService(request.array(), request.order()) ;
//        return sortingService.radixSortService(request.array(), request.order()) ;
    }
}
