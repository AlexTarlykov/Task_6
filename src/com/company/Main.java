package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("STANDARD IMPLEMENTATION:");
        printAnswer(Logic.answer(Logic.STANDARD_IMPLEMENTATION));
        System.out.println("MY IMPLEMENTATION:");
        printAnswer(Logic.answer(Logic.MY_IMPLEMENTATION));
    }

    public static void printAnswer(Map<StudentMarks, List<String>> answer) {
        for (Map.Entry<StudentMarks, List<String>> x : answer.entrySet()) {
            for (Map.Entry<String, Integer> v : x.getKey().getResults().entrySet()) {
                System.out.println(v.getKey() + " " + v.getValue());
            }
            for (String v : x.getValue()) {
                System.out.println("    " + v);
            }
        }
    }
}
