package com.sparta.ja;

import com.sparta.ja.logging.CleanerLogger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validator {
    private static Set<String> employeeSet = new HashSet<>();
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static Logger logger = CleanerLogger.getLogger();
    public static boolean validate(EmployeeDTO employee){
        logger.log(Level.INFO, "Validating values for employee record");
        if (employeeSet.add(employee.getEmpId())){
            logger.log(Level.INFO, "Employee ID is not a duplicate");
            if (isValidDateCheck(employee.getDob())) {
                logger.log(Level.INFO, "Dates for DOB are valid");
                if (isValidDateCheck(employee.getDateOfJoining())) {
                    logger.log(Level.INFO, "Dates for date of joining are valid");
                    return true;
                } else {
                    logger.log(Level.INFO, "Dates for date of joining are invalid");
                    return false;
                }
            } else {
                logger.log(Level.INFO, "Dates for DOB are invalid");
                return false;
            }
        } else {
            logger.log(Level.INFO, "Employee ID is a duplicate");
            return false;
        }

    }

    public static boolean isValidDateCheck(String date){
        return isValidDateFormat(date) && isValidDate(date);
    }

    public static boolean isValidDateFormat(String date){
        logger.log(Level.INFO, "Checking dates are in the correct format");
        try {
            dateFormatter.parse(date);
            logger.log(Level.INFO, "Date is in the correct format");
            return true;
        } catch (DateTimeParseException e) {
            logger.log(Level.INFO, "Date is not in the correct format");
            return false;
        }
    }

    public static boolean isValidDate(String date){
        logger.log(Level.INFO, "Checking date is not in the future");
        LocalDate localDate = LocalDate.now();
        LocalDate inputDate = LocalDate.parse(date, dateFormatter);
        return inputDate.isBefore(localDate);
    }


}
