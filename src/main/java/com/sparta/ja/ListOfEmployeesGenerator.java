package com.sparta.ja;

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

public class ListOfEmployeesGenerator {

    private static final ArrayList<EmployeeDTO> listOfCleanEmployees = new ArrayList<>();
    private static final ArrayList<EmployeeDTO> listOfCorruptEmployees = new ArrayList<>();

    public static void readFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); //ignores first line of made up of headers
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
                String[] employeeDetails = line.split(",");

                EmployeeDTO employeeDTO = new EmployeeDTO(employeeDetails);

                if (Validator.validate(employeeDTO)){
                    listOfCleanEmployees.add(employeeDTO);
                } else {
                    listOfCorruptEmployees.add(employeeDTO);
                }
            }
            System.out.println(listOfCleanEmployees.size());
            System.out.println(listOfCorruptEmployees.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
