package com.sparta.ja.jdbc;


import com.sparta.ja.employee.EmployeeDTO;

import java.sql.*;

public class EmployeeDAO {

    private Connection con;
    private Statement statement;

    public EmployeeDAO(Connection con) {
        this.con = con;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAllEmployees(){
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getString(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getString(8));
                System.out.println(resultSet.getString(9));
                System.out.println(resultSet.getString(10));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertEmployee(String empId, String namePrefix, String firstName, String middleInitial, String lastName,
                               String gender, String email, String dob, String dateOfJoining, String salary){

        try {
            PreparedStatement preparedStatement = con.prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setString(1, empId);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, dob);
            preparedStatement.setString(9, dateOfJoining);
            preparedStatement.setString(10, salary);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertEmployee(EmployeeDTO employee){

        try {
            PreparedStatement preparedStatement = con.prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setInt(1, employee.getEmpId());
            preparedStatement.setString(2, employee.getNamePrefix());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, String.valueOf(employee.getMiddleInitial()));
            preparedStatement.setString(5, employee.getLastName());
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setDate(8, Date.valueOf(employee.getDob()));
            preparedStatement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
            preparedStatement.setInt(10, employee.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

