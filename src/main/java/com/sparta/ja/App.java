package com.sparta.ja;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        ListOfEmployeesGenerator.readFromFile("src/main/resources/EmployeeRecords.csv");
    }

}
