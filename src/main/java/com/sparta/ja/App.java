package com.sparta.ja;


import com.sparta.ja.logging.CleanerLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App
{
    private static Logger logger = CleanerLogger.getLogger();
    public static void main( String[] args )
    {
        CleanerLogger.setLoggerConfig();
        logger.log(Level.INFO, "Starting program");
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecords.csv");
    }

}
