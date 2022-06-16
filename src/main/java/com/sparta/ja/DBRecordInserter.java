package com.sparta.ja;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DBRecordInserter {

    private static ThreadPoolExecutor threadPool;
    private static int employeeArrayLimit;


    public static void setThreadPool(int arrayLimit) {
        employeeArrayLimit = arrayLimit;
    }

    public static void insertRecords() {
        setThreadPool();
        getSeparateEmployeeArray(ListOfEmployeesGenerator.getListOfCleanEmployees());
        threadPool.shutdown();
    }
    
    public static void setThreadPool() {
        int threadCount = ListOfEmployeesGenerator.getListOfCleanEmployees().size() / employeeArrayLimit + 1;
        threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);
        threadPool.prestartAllCoreThreads();
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
    }


}
