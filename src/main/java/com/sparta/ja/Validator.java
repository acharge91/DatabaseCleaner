package com.sparta.ja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static Set<String> employeeSet = new HashSet<>();
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    public static boolean validate(EmployeeDTO employee){

        if (employeeSet.add(employee.getEmpId())){
            if (isValidDateCheck(employee.getDob())) {
                if (isValidDateCheck(employee.getDateOfJoining())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }


//    public static void checkForDuplicates(ArrayList<EmployeeDTO> list){
//        for(EmployeeDTO emp : list){
//            if (employeeSet.add(emp.getEmpId())){
//                listOfCleanEmployees.add(emp);
//            } else {
//                listOfCorruptEmployees.add(emp);
//            }
//        }
//    }

    public static boolean isValidDateCheck(String date){
        return isValidDateFormat(date) && isValidDate(date);
    }

    public static boolean isValidDateFormat(String date){
        try {
            dateFormatter.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidDate(String date){
        LocalDate localDate = LocalDate.now();

        LocalDate inputDate = LocalDate.parse(date, dateFormatter);

        return inputDate.isBefore(localDate);
    }


}
