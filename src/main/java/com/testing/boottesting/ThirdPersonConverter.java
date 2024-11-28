package com.testing.boottesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThirdPersonConverter {
    public static List<String> convert(String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ThirdPersonInfo[] thirdPersonInfos = objectMapper.readValue(jsonStr, ThirdPersonInfo[].class);
            return Arrays.stream(thirdPersonInfos)
                    .sorted(Comparator.comparing(ThirdPersonInfo::getOrder))
                    .map(ThirdPersonInfo::getThirdPersonId)
                    .toList();
        } catch (JsonProcessingException e) {
            System.out.println("catch");;
            return null;
        }
    }

    public static void main(String[] args) {
        String jsonString = "";
        convert(jsonString).forEach(System.out::println);
    }
}