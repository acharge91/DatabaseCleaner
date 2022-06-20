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
        runProgram(8200, "src/main/resources/EmployeeRecordsLarge.csv");

    }

    public static void runProgram(int arrayLimit, String csvFile) {

        ThreadManager.setEmployeeArrayLimit(arrayLimit);
        CleanerLogger.setLoggerConfig();
        logger.log(Level.INFO, "Starting program");
        double startTime = System.nanoTime();
        PerformanceTimer.setStartTime(startTime);
        ListOfEmployeesGenerator.readFromFile(csvFile);

        ThreadManager.insertRecords();


        ListOfEmployeesGenerator.writeEntriesToFile();
    }

}
