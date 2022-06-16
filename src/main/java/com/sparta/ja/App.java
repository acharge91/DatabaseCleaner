package com.sparta.ja;


import com.sparta.ja.logging.CleanerLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App
{
    private static Logger logger = CleanerLogger.getLogger();
    public static void main( String[] args )
    {
        CleanerLogger.setLoggerConfig();
        logger.log(Level.INFO, "Starting program");
        long startTime = System.nanoTime();
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecords.csv");

        DBRecordInserter.insertRecords();
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1_000_000_000;

        System.out.println(totalTime + " seconds");

    }

}
