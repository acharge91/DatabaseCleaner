package com.sparta.ja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBRecordInserter {



    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9));

    }
    private static void getSeparateEmployeeArray(List<EmployeeDTO> employees) {

        if (employees.size() <= 1000) { return; }

        int middleIndex = employees.size() / 2;

        List<EmployeeDTO> employeesArrayOne = employees.subList(0, middleIndex);
        List<EmployeeDTO> employeesArrayTwo = employees.subList(middleIndex, employees.size());

        getSeparateEmployeeArray(employeesArrayOne);
        getSeparateEmployeeArray(employeesArrayTwo);

        createThread(employeesArrayOne);
        createThread(employeesArrayTwo);

    }

    private static void createThread(List<EmployeeDTO> employees) {
        ThreadCreator newThread = new ThreadCreator(employees);
        newThread.run();
    }


}
