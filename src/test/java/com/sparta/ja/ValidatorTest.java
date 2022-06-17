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
    @DisplayName("Check Valid Month Returns True")
    void checkValidMonthReturnsTrue() {
        String testMonthFormat = "06/10/2020";
        Assertions.assertTrue(Validator.isValidDateFormat(testMonthFormat));
    }

    @Test
    @DisplayName("Check Invalid Month Returns false")
    void checkInvalidMonthReturnsFalse() {
        String testMonthFormat = "23/06/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testMonthFormat));
    }
    @Test
    @DisplayName("Check a Negative Invalid Month Returns false")
    void checkANegativeInvalidMonthReturnsFalse() {
        String testMonthFormat = "-10/06/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testMonthFormat));
    }
    @Test
    @DisplayName("Check a Null Month Returns false")
    void checkNullMonthReturnsFalse() {
        String testMonthFormat = "/06/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testMonthFormat));
    }




    @Test
    @DisplayName("Check Leading zeros return True")
    void checkLeadingZerosReturnTrue() {
        String testZeroFormat = "06/09/2020";
        Assertions.assertTrue(Validator.isValidDateFormat(testZeroFormat));
    }
    @Test
    @DisplayName("Check Without Leading zeros return True")
    void checkWithoutLeadingZerosReturnTrue() {
        String testZeroFormat = "6/09/2020";
        Assertions.assertTrue(Validator.isValidDateFormat(testZeroFormat));
    }



    @Test
    @DisplayName("Check Valid Day return True")
    void checkValidDayReturnTrue() {
        String testDayFormat = "06/15/2020";
        Assertions.assertTrue(Validator.isValidDateFormat(testDayFormat));
    }


    @Test
    @DisplayName("Check Invalid Day Returns false")
    void checkInvalidDayReturnsFalse() {
        String testDayFormat = "08/35/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testDayFormat));
    }
    @Test
    @DisplayName("Check a Null  Day Returns false")
    void checkNullDayReturnsFalse() {
        String testDayFormat = "08//2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testDayFormat));
    }

    @Test
    @DisplayName("Check a Negative  Day Returns false")
    void checkNegativeDayReturnsFalse() {
        String testDayFormat = "08/-25/2020";
        Assertions.assertFalse(Validator.isValidDateFormat(testDayFormat));
    }



    @Test
    @DisplayName("Check Invalid Year Returns False")
    void checkInvalidYearReturnsFalse() {
        String testYearFormat = "06/06/2035";
        Assertions.assertFalse(Validator.isValidDate(testYearFormat));
    }

    @Test
    @DisplayName("Check a valid Year returns True")
    void checkIfItReturnsAValidYear() {
        String testYearFormat = "06/06/2010";
        Assertions.assertTrue(Validator.isValidDate(testYearFormat));
    }
    @Test
    @DisplayName("Check for a future Year Returns False")
    void checkForaFutureYearReturnsFalse() {
        String testYearFormat = "06/06/2030";
        Assertions.assertFalse(Validator.isValidDate(testYearFormat));
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

    void checkIfaGenderIsInvalidinUppercase() {

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
    void checkIfThereIsOnlyOneMiddleNameInitialInLowerCase() {
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
    @DisplayName("Check if there are more then one Middle name Initial is False")
    void checkIfThereAreMoreThenOneMiddleNameInitialIsFalse() {
        String testMiddleNameFormat = "False";
        Assertions.assertFalse(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }
    @Test
    @DisplayName("Check if there are more then one Middle name Initial is True")
    void checkIfThereAreMoreThenOneMiddleNameInitialIsTrue() {
        String testMiddleNameFormat = "True";
        Assertions.assertFalse(Validator.isValidMiddleInitial(testMiddleNameFormat));
    }



    @Test
    @DisplayName("Check if the Salary is Valid")
    void checkIfTheSalaryIsValid() {
        String testSalary = "10000";
        Assertions.assertTrue(Validator.isValidSalary(testSalary));
    }
    @Test
    @DisplayName("Check that Salary of Zero Returns True")
    void checkThatSalaryOfZeroReturnsTrue() {
        String testSalary = "0";
        Assertions.assertTrue(Validator.isValidSalary(testSalary));
    }
    @Test
    @DisplayName("Check the Negative Salary Returns False")
    void checkTheNegativeSalaryReturnsFalse() {
        String testSalary = "-10000";
        Assertions.assertFalse(Validator.isValidSalary(testSalary));
    }
    @Test
    @DisplayName("Check that Valid Email Format Returns True")
    void checkValidEmailReturnsTrue() {
        String testEmailFormat = "haji.kulfi@gmail.com";
        Assertions.assertTrue(Validator.isValidEmailFormat(testEmailFormat));
    }

    @Test
    @DisplayName("Check that Invalid Email Format Returns False")
    void checkInvalidEmailReturnsFalse() {
        String testEmailFormat = "fsbfsdfc.com";
        Assertions.assertFalse(Validator.isValidEmailFormat(testEmailFormat));
    }

    @Test
    @DisplayName("Check that Empty Email Format Returns False")
    void checkEmptyEmailReturnsFalse() {
        String testEmailFormat = "";
        Assertions.assertFalse(Validator.isValidEmailFormat(testEmailFormat));
    }

}
