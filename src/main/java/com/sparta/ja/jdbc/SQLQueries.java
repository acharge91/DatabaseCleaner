package com.sparta.ja.jdbc;

public interface SQLQueries {


    String SELECT_ALL = "SELECT * FROM public.employees";
    String INSERT_INTO_DB = "INSERT INTO public.employees (\"empId\", \"namePrefix\", \"firstName\", \"middleInitial\", \"lastName\", \"gender\", " +
            "\"email\", \"dob\", \"dateOfJoining\", \"salary\") VALUES (?,?,?,?,?,?,?,?,?,?)";
    String DELETE_ALL_RECORDS = "TRUNCATE employees;";
}

