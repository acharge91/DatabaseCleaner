package com.sparta.ja;

import com.sparta.ja.logging.CleanerLogger;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListOfEmployeesGenerator {

    private static final List<EmployeeDTO> listOfCleanEmployees = new ArrayList<>();
    private static final List<EmployeeDTO> listOfCorruptEmployees = new ArrayList<>();
    private static Logger logger = CleanerLogger.getLogger();
    private static int count = 2;
    private static String headers;

    public static void readFromFile(String fileName) {
//        logger.log(Level.INFO, "Attempting to read CSV file");
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            headers = bufferedReader.readLine(); //ignores first line of made up of headers
            logger.log(Level.INFO, "Iterating through records in " + fileName);

            addEmployeesToArrays(bufferedReader);

//            System.out.println(listOfCleanEmployees.size());
//            System.out.println(listOfCorruptEmployees.size());

        } catch (FileNotFoundException e) {
//            logger.log(Level.INFO, "FileNotFoundException caught");
            throw new RuntimeException(e);
        } catch (IOException e) {
//            logger.log(Level.INFO, "IOException caught");
            throw new RuntimeException(e);
        }
    }

    private static void addEmployeesToArrays(BufferedReader bufferedReader) throws IOException {
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
//            logger.log(Level.INFO, "Processing line " + count + " in file");
            String[] employeeDetails = line.split(",");

            if(employeeDetails.length>0) {
                EmployeeDTOString employeeDTOString = new EmployeeDTOString(employeeDetails);


                if (Validator.validate(employeeDTOString)) {
                    listOfCleanEmployees.add(new EmployeeDTO(employeeDTOString));
//                logger.log(Level.INFO, "Adding employee into clean dataset");
                } else {
                    listOfCorruptEmployees.add(new EmployeeDTO(employeeDTOString));
//                logger.log(Level.INFO, "Adding employee into corrupted dataset");
                }
            count++;}
        }

//        DBRecordInserter.getSeparateEmployeeArray(listOfCleanEmployees);
    }

    public static List<EmployeeDTO> getListOfCleanEmployees() {
        return listOfCleanEmployees;
    }

    public static void writeEntriesToFile(){

            try {
                FileWriter fileWriter = new FileWriter("src/main/resources/CorruptRecords.csv");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(headers + "\n");
                for (EmployeeDTO employeeDTO : listOfCorruptEmployees){
                    bufferedWriter.write(employeeDTO.toString() + "\n");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }


}
