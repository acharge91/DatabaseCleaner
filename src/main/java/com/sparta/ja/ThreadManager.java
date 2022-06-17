package com.sparta.ja;

import com.sparta.ja.employee.EmployeeDTO;
import com.sparta.ja.employee.ListOfEmployeesGenerator;
import com.sparta.ja.recordmanager.DBRecordInserter;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    private static ThreadPoolExecutor threadPool;
    private static int employeeArrayLimit;


    public static void setEmployeeArrayLimit(int arrayLimit) {
        employeeArrayLimit = arrayLimit;
    }

    public static void insertRecords() {
        setThreadPool();
        getSeparateEmployeeArray(ListOfEmployeesGenerator.getListOfCleanEmployees());
        threadPool.shutdown();
        try {
            if (threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                double endTime = System.nanoTime();
                PerformanceTimer.setEndTime(endTime);
                PerformanceTimer.setTotalTime();
            };
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        DBRecordInserter employeesThread = new DBRecordInserter(employees);
        threadPool.execute(employeesThread);
    }


}
