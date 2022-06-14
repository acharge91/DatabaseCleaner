package com.sparta.ja.jdbc;

public interface SQLQueries {
    public static String SELECT_ALL="SELECT * FROM employees.employees";

    String INSERT_iNTO_dB ="INSERT INTO employees.employees (\n " +
            "(empID, namePrefix, firstName, middleInitial," +
            "lastName, gender, email, dob ,dateOfJoining, " +
            "salary) VALUES (?,?,?,?,?,?,?,?,?,?)";

}
