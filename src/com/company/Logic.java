package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logic {
    public static final boolean MY_IMPLEMENTATION = true;
    public static final boolean STANDARD_IMPLEMENTATION = false;

    public static Map<StudentMarks, List<String>> answer(boolean choose) throws IOException {
        Map<String, StudentMarks> studentMarksMap = (choose) ? FileWork.dataForMyMap() : FileWork.dataForJavaMap();
        ArrayList<StudentMarks> marks = new ArrayList<>();
        for (Map.Entry<String, StudentMarks> v : studentMarksMap.entrySet()) {
            boolean a = true;
            for (StudentMarks x : marks) {
                if (x.compareTo(v.getValue()) == 0) {
                    a = false;
                    break;
                }
            }
            if (a) {
                marks.add(v.getValue());
            }
        }
        Map<StudentMarks, List<String>> answer = (choose) ? new SimpleHashMap<>(marks.size()) : new HashMap<>(marks.size());
        boolean i = true;
        for (StudentMarks v : marks) {
            for (Map.Entry<String, StudentMarks> x : studentMarksMap.entrySet()) {
                if (v.compareTo(x.getValue()) == 0) {
                    if (i) {
                        answer.put(v, new ArrayList<>());
                        i = false;
                    }
                    answer.get(v).add(x.getKey());
                }
            }
            i = true;
        }
        return answer;
    }
}
