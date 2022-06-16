package com.sparta.ja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBRecordInserter {

    private static ExecutorService threadPool;
    private static int employeeArrayLimit = 8500;

    public static void insertRecords() {
        setThreadPool();
        getSeparateEmployeeArray(ListOfEmployeesGenerator.getListOfCleanEmployees());
        threadPool.shutdown();
    }
    
    public static void setThreadPool() {
        int threadCount = ListOfEmployeesGenerator.getListOfCleanEmployees().size() / employeeArrayLimit + 1;
        threadPool = Executors.newFixedThreadPool(threadCount);
    }

    public static void getSeparateEmployeeArray(List<EmployeeDTO> employees) {

        if (employees.size() <= employeeArrayLimit) {
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
        threadPool.execute(employeesThread);
//        Thread thread = new Thread(employeesThread);
//        thread.start();
    }


}
