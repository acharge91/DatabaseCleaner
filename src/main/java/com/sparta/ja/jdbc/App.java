package com.sparta.ja.jdbc;

import com.sparta.ja.EmployeeDTO;

import java.sql.*;

public class App {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.getConnection());
        employeeDAO.insertEmployee("1", "Mr.", "Josh", "A", "Austin", "M", "me@me.com", "16/12/1996",
                "16/05/2022", "23000");
        employeeDAO.printAllEmployees();
        ConnectionManager.closeConnection();
    }
}
