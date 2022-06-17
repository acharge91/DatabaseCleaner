package com.sparta.ja;


import com.sparta.ja.employee.ListOfEmployeesGenerator;
import com.sparta.ja.logging.CleanerLogger;
import com.sparta.ja.recordmanager.DBRecordsDeleter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App
{
    private static Logger logger = CleanerLogger.getLogger();
    public static void main( String[] args )
    {
        DBRecordsDeleter.deleteAllRecordsFromDatabase();
        ThreadManager.setEmployeeArrayLimit(8200);
        CleanerLogger.setLoggerConfig();
        logger.log(Level.INFO, "Starting program");
        double startTime = System.nanoTime();
        PerformanceTimer.setStartTime(startTime);
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecordsLarge.csv");

        ThreadManager.insertRecords();


        ListOfEmployeesGenerator.writeEntriesToFile();

    }

}
