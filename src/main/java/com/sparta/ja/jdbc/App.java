package com.sparta.ja.jdbc;

import java.sql.*;

public class App {



        public static void main(String[] args) {
           EmployeeDAO employeeDAO= new EmployeeDAO(ConnectionManager.getConnection());
           employeeDAO.insertEmployee("1","Dr","Haji","K","Kulfi","M","hajikulfi@gmail.com","27/06/1899","28/06/1999","10");
           employeeDAO.printAllEmployees();
           ConnectionManager.closeConnection();

        }
    }


