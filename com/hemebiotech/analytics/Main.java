package com.hemebiotech.analytics;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "symptoms.txt"; // url of the file to be analysed
        ReadSymptomDataFromFile analyseFile = new ReadSymptomDataFromFile(file); // recovering symptoms and their occurrences
        new OrganiseData(analyseFile).displayData(); // display symptoms uniquely with their occurrences
    }
}