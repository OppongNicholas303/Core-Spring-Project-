package com.spring.lab.controller;

import com.spring.lab.DTO.SortDTO;
import com.spring.lab.service.SortingService;
import com.spring.lab.util.AlgorithmReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sort")
public class SortingController {
private AlgorithmReturn algorithmReturn;

    @Autowired
    public SortingController(AlgorithmReturn algorithmReturn ) {
        this.algorithmReturn = algorithmReturn;
    }

    @PostMapping("/")
    public String heapSort(
            @RequestBody SortDTO request
    ) {
        return algorithmReturn.algorithm(request.array(), request.order(), request.algorithm());
    }
}
