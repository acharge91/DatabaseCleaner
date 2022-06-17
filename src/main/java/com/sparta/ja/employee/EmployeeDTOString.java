package com.sparta.ja.employee;

import com.sparta.ja.logging.CleanerLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDTOString {

    private String empId;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private String dob; //private LocalDate dob;
    private String dateOfJoining;
    private String salary;
    private boolean isClean;
    private static Logger logger = CleanerLogger.getLogger();

    public EmployeeDTOString(String empId, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String dateOfJoining, String salary) {
        this.empId = empId;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        logger.log(Level.INFO, "Creating employee from multiple separate values");
    }

    public EmployeeDTOString(String[] fileRecord) {
        this.empId = fileRecord[0];
        this.namePrefix = fileRecord[1];
        this.firstName = fileRecord[2];
        this.middleInitial = fileRecord[3];
        this.lastName = fileRecord[4];
        this.gender = fileRecord[5];
        this.email = fileRecord[6];
        this.dob = fileRecord[7];
        this.dateOfJoining = fileRecord[8];
        this.salary = fileRecord[9];
        logger.log(Level.INFO, "Creating employee from values in String array");
    }

    @Override
    public String toString() {
        logger.log(Level.INFO, "toString method for employee called");
        return "EmployeeDTOString{" +
                "empId='" + empId + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }
}
