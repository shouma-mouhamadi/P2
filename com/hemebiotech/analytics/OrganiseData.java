package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.constant.Constable;
import java.util.*;

public class OrganiseData {

    public ReadSymptomDataFromFile Data;
    public TreeMap<Integer, java.lang.constant.Constable> tm = new TreeMap<>();
    public OrganiseData(ReadSymptomDataFromFile AnalyseData) {
        this.Data = AnalyseData;
    }

    public TreeMap<Integer, Constable> formaliseData(){
        ArrayList<String> list = new ArrayList<String>();
        boolean doubloon = false; // Detecting symptom repetition
        for (int i=0 ; i < Data.GetSymptoms().size() ; i++){
            for (String s : list) {
                if (s.equals(Data.GetSymptoms().get(i))) {
                    doubloon = true;
                }
            }
            if (!doubloon) { // this symptom first appears
                list.add(i, Data.GetSymptoms().get(i));
            }
            else {
                list.add(i, "DOUBLOON");
                doubloon = false;
            }
        }
        Collections.sort(list); // Sort symptoms alphabetically
        for (int i=0 ; i < list.size() ; i++){ // Record symptoms in a Treemap
            if(!list.get(i).equals("DOUBLOON")){
                this.tm.put(i, list.get(i) + " ; " + Data.CountSymptoms(list.get(i).toString()) + " ;");
            }
        }
        return this.tm;
    }

    public void displayData() throws FileNotFoundException { // show treemap values
        PrintWriter writer = new PrintWriter("symptoms_out.csv");
        Set<Map.Entry<Integer, java.lang.constant.Constable>> set = this.formaliseData().entrySet();
        for (Map.Entry<Integer, java.lang.constant.Constable> mapentry : set) {
            /* System.out.print(mapentry.getValue() + "\n"); // displays data in the console */
            writer.print(mapentry.getValue() + "\n");  // write the data to an output file
        }
        writer.close();
    }



}