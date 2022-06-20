package com.sparta.ja;

import com.sparta.ja.employee.ListOfEmployeesGenerator;
import com.sparta.ja.recordmanager.DBRecordsDeleter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PerformanceTester {


    @Test
    @DisplayName("Test Performance of a csv file with 1000 Entries")
    void checkThePerformanceWith1000Entries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase();
        System.out.println("\nTest on 1000 entries CSV");
        App.runProgram(8200, "src/main/resources/EmployeeRecords1k.csv");
        System.out.println("Time taken.");
    }

    @Test
    @DisplayName("Test Performance of a csv file with 5000 Entries")
    void checkThePerformanceWith5000Entries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase();
        System.out.println("\nTest on 5000 entries CSV");
        App.runProgram(8200, "src/main/resources/EmployeeRecords5k.csv");
        System.out.println("Time taken.");
    }

    @Test
    @DisplayName("Test Performance of a csv file with 30K Entries")
    void checkThePerformanceWith30kEntries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase();
        System.out.println("\nTest on 30000 entries CSV");
        App.runProgram(8200, "src/main/resources/EmployeeRecords30k.csv");
        System.out.println("Time taken.");
    }

    @Test
    @DisplayName("Test Performance of a csv file with 100k entries")
    void checkThePerformanceWith100kEntries(){
        DBRecordsDeleter.deleteAllRecordsFromDatabase();
        System.out.println("\nTest on 100000 entries CSV");
        App.runProgram(8200, "src/main/resources/EmployeeRecords100k.csv");
        System.out.println("Time taken.");
    }

}
