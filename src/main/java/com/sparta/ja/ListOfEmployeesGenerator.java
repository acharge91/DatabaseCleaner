package com.sparta.ja;

import com.sparta.ja.logging.CleanerLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListOfEmployeesGenerator {

    private static final ArrayList<EmployeeDTO> listOfCleanEmployees = new ArrayList<>();
    private static final ArrayList<EmployeeDTO> listOfCorruptEmployees = new ArrayList<>();
    private static Logger logger = CleanerLogger.getLogger();

    public static void readFromFile(String fileName) {
        logger.log(Level.INFO, "Attempting to read CSV file");
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); //ignores first line of made up of headers
            logger.log(Level.INFO, "Iterating through records in file");
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
                String[] employeeDetails = line.split(",");

                EmployeeDTO employeeDTO = new EmployeeDTO(employeeDetails);

                if (Validator.validate(employeeDTO)){
                    listOfCleanEmployees.add(employeeDTO);
                    logger.log(Level.INFO, "Adding employee into clean dataset");
                } else {
                    listOfCorruptEmployees.add(employeeDTO);
                    logger.log(Level.INFO, "Adding employee into corrupted dataset");
                }
            }
            System.out.println(listOfCleanEmployees.size());
            System.out.println(listOfCorruptEmployees.size());

        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "FileNotFoundException caught");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.log(Level.INFO, "IOException caught");
            throw new RuntimeException(e);
        }
    }
}
