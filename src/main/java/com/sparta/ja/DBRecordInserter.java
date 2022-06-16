package com.sparta.ja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBRecordInserter {

    public static void insertRecords() {
        getSeparateEmployeeArray(ListOfEmployeesGenerator.getListOfCleanEmployees());
    }

    public static void getSeparateEmployeeArray(List<EmployeeDTO> employees) {

        if (employees.size() <= 1000) {
            createThread(employees);
            return; }

        int middleIndex = employees.size() / 2;

        List<EmployeeDTO> employeesArrayOne = employees.subList(0, middleIndex);
        List<EmployeeDTO> employeesArrayTwo = employees.subList(middleIndex, employees.size());

        getSeparateEmployeeArray(employeesArrayOne);
        getSeparateEmployeeArray(employeesArrayTwo);

    }

    private static void createThread(List<EmployeeDTO> employees) {
        ThreadCreator employeesThread = new ThreadCreator(employees);
        Thread thread = new Thread(employeesThread);
        thread.start();
    }


}
