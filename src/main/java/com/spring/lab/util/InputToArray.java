package com.spring.lab.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InputToArray {

    public List<Integer> toIntArray(String input) {
        String[] split = input.split(",");
        List<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            intArray.add(Integer.parseInt(split[i]));
        }

        return intArray;
    }
}
