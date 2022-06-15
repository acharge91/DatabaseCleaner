package com.sparta.ja;

import com.sparta.ja.jdbc.ConnectionManager;
import com.sparta.ja.jdbc.EmployeeDAO;

import java.sql.Connection;
import java.util.List;

public class ThreadCreator implements Runnable{

    private final List<EmployeeDTO> employeeList;
    private final Connection DBConnection;

    public ThreadCreator(List<EmployeeDTO> employeeList) {
        this.employeeList = employeeList;
        this.DBConnection = ConnectionManager.getConnection();
    }

    @Override
    public void run() {
        EmployeeDAO employeeDAO = new EmployeeDAO(DBConnection);
        for (EmployeeDTO employee : employeeList) {
            employeeDAO.insertEmployee(employee);
        }
    }
}
