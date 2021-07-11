package com.hemebiotech.analytics;

public class Main {

    public static void main(String args[]){
        String file = "symptoms.txt";
        ReadSymptomDataFromFile AnalyzeData = new ReadSymptomDataFromFile(file);
        /*System.out.println(AnalyzeData.GetSymptoms());
        System.out.println(AnalyzeData.CountSymptoms("stomach pain"));*/
        new OrganiseData(AnalyzeData).afficher();
    }

}
