package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args){
        String file = "symptoms.txt";
        ReadSymptomDataFromFile AnalyseData = new ReadSymptomDataFromFile(file);
        new OrganiseData(AnalyseData).display();
    }

}
