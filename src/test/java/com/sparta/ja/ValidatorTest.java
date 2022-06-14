package com.sparta.ja;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.time.format.DateTimeFormatter;


public class ValidatorTest {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    @Test
    @DisplayName("Check Valid Date Format(M/D/YYYY) Returns True")
    void checkValidDateFormatReturnsTrue() {
        String testDateFormat = "11/12/1967";
        Assertions.assertTrue(Validator.isValidDateFormat(testDateFormat));
    }

    @Test
    @DisplayName("Check Invalid Month Returns false")
    void checkInvalidMonthReturnsFalse() {
        String testDateFormat = "23/06/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testDateFormat));
    }

    @Test
    @DisplayName("Check Leading zeros return True")
    void checkLeadingZerosReturnTrue() {
        String testDateFormat = "06/09/2020";
        Assertions.assertTrue(Validator.isValidDateFormat(testDateFormat));
    }

    @Test
    @DisplayName("Check Invalid Day Returns false")
    void checkInvalidDayReturnsFalse() {
        String testDateFormat = "08/35/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testDateFormat));
    }

    @Test
    @DisplayName("Check Invalid Year Returns False")
    void checkInvalidYearReturnsFalse() {
        String testDateFormat = "06/06/2035";
        Assertions.assertFalse(Validator.isValidDate(testDateFormat));
    }

    @Test
    @DisplayName("Check a valid Year returns True")
    void checkIfItReturnsAValidYear() {
        String testDateFormat = "06/06/2010";
        Assertions.assertTrue(Validator.isValidDate(testDateFormat));
    }

    @Test
    @DisplayName("Check if the gender is valid")
    void checkForaValidGender() {
        String testGenderFormat = "M";
        Assertions.assertTrue(Validator.isValidGender(testGenderFormat));
    }

    @Test
    @DisplayName("Check if a gender is Invalid")
    void checkIfaGenderIsInvalid() {
        String testGenderFormat = "X";
        Assertions.assertFalse(Validator.isValidGender(testGenderFormat));
    }
    @Test
    @DisplayName("Check if the Gender is Male")
    void checkIftheGenderIsMale() {
        String testGenderFormat = "M";
        Assertions.assertTrue(Validator.isValidGender(testGenderFormat));
    }
    @Test
    @DisplayName("Check if the Gender is Female")
    void checkIftheGenderIsFemale() {
        String testGenderFormat = "F";
        Assertions.assertTrue(Validator.isValidGender(testGenderFormat));
    }
    @Test
    @DisplayName("Check if the Gender is Female in Lowercase")
    void checkIftheGenderIsFemaleInLowercase() {
        String testGenderFormat = "f";
        Assertions.assertTrue(Validator.isValidGender(testGenderFormat));
    }
    @Test
    @DisplayName("Check if the Gender is Male in Lowercase")
    void checkIftheGenderIsMaleinLowercase() {
        String testGenderFormat = "m";
        Assertions.assertTrue(Validator.isValidGender(testGenderFormat));
    }
    @Test
    @DisplayName("Check the gender in Uppercase")
    void checkIfaGenderIsInvalidUppercase() {
        String testGenderFormat = "C";
        Assertions.assertFalse(Validator.isValidGender(testGenderFormat));
    }
    @Test
    @DisplayName("Check the gender in Lowercase")
    void checkIfaGenderIsInvalidLowercase() {
        String testGenderFormat = "d";
        Assertions.assertFalse(Validator.isValidGender(testGenderFormat));
    }



    @Test
    @DisplayName("Check if there is only one Middle name Initial")
    void checkIfThereisOnlyOneMiddleNameInitial() {
        String testMiddleNameFormat = "A";
        Assertions.assertTrue(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }
    @Test
    @DisplayName("Check if there is only one Middle name Initial in Lowercase")
    void checkIfThereisOnlyOneMiddleNameInitialinLowerCase() {
        String testMiddleNameFormat = "a";
        Assertions.assertTrue(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }


    @Test
    @DisplayName("Check if there are more then one Middle name Initial")
    void checkIfThereAreMoreThenOneMiddleNameInitial() {
        String testMiddleNameFormat = "AS";
        Assertions.assertFalse(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }
    @Test
    @DisplayName("Check if there are more then one Middle name Initial in lowercase")
    void checkIfThereAreMoreThenOneMiddleNameInitialInLowercase() {
        String testMiddleNameFormat = "df";
        Assertions.assertFalse(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }
    @Test
    @DisplayName("Check if there are more then one Middle name Initial in Upper and Lowercase")
    void checkIfThereAreMoreThenOneMiddleNameInitialInUpperAndLowercase() {
        String testMiddleNameFormat = "Gh";
        Assertions.assertFalse(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }



    @Test
    @DisplayName("Check if the Salary is Valid")
    void checkIfTheSalaryIsValid() {
        String testSalary = "10000";
        Assertions.assertTrue(Validator.isValidSalary(testSalary));
    }
    @Test
    @DisplayName("Check if the Salary is Zero")
    void checkIfTheSalaryIsZero() {
        String testSalary = "0";
        Assertions.assertTrue(Validator.isValidSalary(testSalary));
    }
    @Test
    @DisplayName("Check if the Salary is Invalid")
    void checkIfTheSalaryIsInvalid() {
        String testSalary = "-10000";
        Assertions.assertFalse(Validator.isValidSalary(testSalary));
    }

}
