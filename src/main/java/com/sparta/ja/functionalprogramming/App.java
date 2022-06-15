package com.sparta.ja.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class App {

    public static void main(String[] args) {

        //method to check if a string contains all the letters of the alphabet
        String sentence = "The Quick brown fox jumps over the lazy dog";

        boolean hasAllLetters = sentence.toLowerCase().chars()
                .filter(letter -> letter >= 'a' && letter <= 'z')
                .distinct()
                .count() == 26;
        System.out.println(hasAllLetters);


        ArrayList<String> beatles = new ArrayList<>(Arrays.asList("John", "Paul", "George", "Ringo"));

        beatles.stream() //created a stream
                .filter(name -> name.contains("o")) //intermediate operations
                .map(String::toUpperCase) //intermediate operations
                .forEach(System.out::println); //terminal operation
    }
}
