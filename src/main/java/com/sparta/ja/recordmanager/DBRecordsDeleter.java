package com.sparta.ja.recordmanager;

import com.sparta.ja.jdbc.ConnectionManager;
import com.sparta.ja.jdbc.EmployeeDAO;
import com.sparta.ja.jdbc.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBRecordsDeleter {

    private static final Connection DBConnection = ConnectionManager.getConnection();

    public static void deleteAllRecordsFromDatabase(){
        try {
            PreparedStatement preparedStatement = DBConnection.prepareStatement(SQLQueries.DELETE_ALL_RECORDS);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
