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
        PerformanceTimer.setStartTime(startTime);
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecordsLarge.csv");

        DBRecordInserter.insertRecords();


        ListOfEmployeesGenerator.writeEntriesToFile();

    }

}
