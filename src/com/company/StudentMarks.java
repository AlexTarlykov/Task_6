package com.company;

import java.util.HashMap;
import java.util.Map;

public class StudentMarks implements Comparable<StudentMarks> {
    public static final boolean MY_IMPLEMENTATION = true;
    public static final boolean STANDARD_IMPLEMENTATION = false;
    private final Map<String, Integer> results;

    StudentMarks(boolean choose) {
        if (choose) {
            results = new SimpleHashMap<>(7);
        } else {
            results = new HashMap<>(7);
        }
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public void put(String lesson, Integer result) {
        results.put(lesson, result);
    }

    @Override
    public int compareTo(StudentMarks o) {
        int sum = 0;
        for (Map.Entry<String, Integer> v : results.entrySet()) {
            for (Map.Entry<String, Integer> x : o.results.entrySet()) {
                if (v.getKey().equals(x.getKey())) {
                    sum += Math.abs(v.getValue() - x.getValue());
                    break;
                }
            }
        }
        return sum;
    }
}
