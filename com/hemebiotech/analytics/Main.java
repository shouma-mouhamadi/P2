package com.hemebiotech.analytics;

import java.io.FileNotFoundException;

/**
 * Main class to run the program
 *
 * @author shouma-mouhamadi
 */
public class Main {
    /**
     * The user must only assign the url of his symptoms file to the 'file' variable (exemple : file = "symptoms.txt")
     *
     * @param args contains the command line arguments provided in the form of an array of String objects
     * @throws FileNotFoundException if the symptom file to be analyzed is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        String file = "symptoms.txt"; // url of the file to be analysed
        ReadSymptomDataFromFile analyseFile = new ReadSymptomDataFromFile(file); // recovering symptoms and their occurrences
        new OrganiseData(analyseFile).displayData(); // display symptoms uniquely with their occurrences
    }
}