package com.sparta.ja;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PerformanceTester {


    @Test
    @DisplayName("Test Performance of a csv file with Thousand Entries")
    void checkThePerformanceWith1000Entries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase
        long startTime = System.nanoTime();
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecords1k.csv");

        DBRecordInserter.insertRecords();
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1_000_000;

        System.out.println(totalTime + " milliseconds for 1000 Entries");
    }

    @Test
    @DisplayName("Test Performance of a csv file with 5000 Entries")
    void checkThePerformanceWith5000Entries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase


        long startTime = System.nanoTime();
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecords5k.csv");

        DBRecordInserter.insertRecords();
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1_000_000;

        System.out.println(totalTime + " milliseconds for 5000 Entries");
    }

    @Test
    @DisplayName("Test Performance of a csv file with 30K Entries")
    void checkThePerformanceWith30kEntries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase
        long startTime = System.nanoTime();
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecords30k.csv");

        DBRecordInserter.insertRecords();
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1_000_000;

        System.out.println(totalTime + " milliseconds for 30k Entries");
    }

    @Test
    @DisplayName("Test Performance of a csv file for a corrupted data with 100k entries")
    void checkThePerformanceWith100kEntries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase
        long startTime = System.nanoTime();
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecordsXXL.csv");

        DBRecordInserter.insertRecords();
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1_000_000;

        System.out.println(totalTime + " milliseconds for 100k Entries");
    }

}
