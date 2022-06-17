package com.sparta.ja.employee;

import com.sparta.ja.Validator;
import com.sparta.ja.logging.CleanerLogger;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDTO {

    private int empId;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dob;
    private LocalDate dateOfJoining;
    private int salary;
    private boolean isClean;
    private static Logger logger = CleanerLogger.getLogger();

    public EmployeeDTO(EmployeeDTOString employee) {
        this.empId = Integer.parseInt(employee.getEmpId());
        this.namePrefix = employee.getNamePrefix();
        this.firstName = employee.getFirstName();
        this.middleInitial = employee.getMiddleInitial();
        this.lastName = employee.getLastName();
        this.gender = employee.getGender();
        this.email = employee.getEmail();
        this.dob = LocalDate.parse(employee.getDob(), Validator.getDateFormatter());
        this.dateOfJoining = LocalDate.parse(employee.getDateOfJoining(), Validator.getDateFormatter());
        this.salary = Integer.parseInt(employee.getSalary());
        logger.log(Level.INFO, "Creating employee with correct data types from EmployeeDTOString");
    }

    @Override
    public String toString() {
        return "Employee: " + empId +
                ", " + namePrefix +
                ", " + firstName +
                ", " + middleInitial +
                ", " + lastName +
                ", " + gender +
                ", " + email +
                ", " + dob +
                ", " + dateOfJoining +
                ", " + salary +
                ", " + isClean;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }
}
