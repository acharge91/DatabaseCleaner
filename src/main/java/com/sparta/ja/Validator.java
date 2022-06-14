package com.sparta.ja;

import com.sparta.ja.logging.CleanerLogger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

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
                    if (isValidGender(employee.getGender())) {
                        logger.log(Level.INFO, "Gender is valid");
                        if (isValidMiddleInitial(employee.getMiddleInitial())) {
                            logger.log(Level.INFO, "Middle initial is valid");
                            if (isValidEmail(employee, employee.getEmail())) {
                                logger.log(Level.INFO, "Email is valid");
                                if (isValidSalary(employee.getSalary())) {
                                    logger.log(Level.INFO, "Salary is valid");
                                    return true;
                                } else {
                                    logger.log(Level.INFO, "Salary is invalid");
                                    return false;
                                }
                            } else {
                                logger.log(Level.INFO, "Email is invalid");
                                return false;
                            }
                        } else {
                            logger.log(Level.INFO, "Middle initial is invalid");
                            return false;
                        }
                    } else {
                        logger.log(Level.INFO, "Gender is invalid");
                        return false;
                    }
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

    public static boolean isValidGender(String gender){
        switch (gender){
            case "M","F","m","f":
                return true;
            default:
                return false;
        }

    }

    public static boolean isValidMiddleInitial(String initial){
        if (initial.length() < 2){
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(EmployeeDTO employee, String email){
        if (employeeSet.add(employee.getEmail()) && isValidEmailFormat(email)){
            return true;
        }
        return false;
    }

    public static boolean isValidEmailFormat(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    public static boolean isValidSalary(String salary){
        if (Integer.parseInt(salary) > 0){
            return true;
        }
        return false;
    }




}
