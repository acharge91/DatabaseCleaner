package com.sparta.ja;


import com.sparta.ja.logging.CleanerLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App
{
    private static Logger logger = CleanerLogger.getLogger();
    public static void main( String[] args )
    {
        DBRecordInserter.setEmployeeArrayLimit(8200);
        CleanerLogger.setLoggerConfig();
//        logger.log(Level.INFO, "Starting program");
        double startTime = System.nanoTime();
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecordsLarge.csv");

        DBRecordInserter.insertRecords();
        double endTime = System.nanoTime();

        double totalTime = (endTime - startTime);

        System.out.println(totalTime + " seconds");
        ListOfEmployeesGenerator.writeEntriesToFile();

    }

}
