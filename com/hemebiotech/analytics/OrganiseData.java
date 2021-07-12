package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.constant.Constable;
import java.util.*;

/**
 * Allows to format data in a file from an instance of the ReadSymptomDataFromFile class
 *
 * @author shouma-mouhamadi
 */
public class OrganiseData {
    /**
     * Read the data and extract the occurrences for each symptom
     */
    public ReadSymptomDataFromFile Data;

    /**
     * Treemap that will contain all symptoms without repetition
     */
    public TreeMap<Integer, java.lang.constant.Constable> tm = new TreeMap<>();

    /**
     * Default constructor
     *
     * @param AnalyseData instance that recovers all symptoms
     */
    public OrganiseData(ReadSymptomDataFromFile AnalyseData) {
        this.Data = AnalyseData;
    }

    /**
     * Detecting symptom repetition
     * Sort symptoms alphabetically
     * Record symptoms in a Treemap
     *
     * @return a treemap containing each symptom in a unique way with their occurrence
     */
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

    /**
     * Show data treemap in the console
     * write the data to an output file
     *
     * @throws FileNotFoundException if ever the file is not found
     */
    public void displayData() throws FileNotFoundException { // show treemap values
        PrintWriter writer = new PrintWriter("symptoms_out.csv");
        Set<Map.Entry<Integer, java.lang.constant.Constable>> set = this.formaliseData().entrySet();
        for (Map.Entry<Integer, java.lang.constant.Constable> mapentry : set) {
            System.out.print(mapentry.getValue() + "\n"); // displays data in the console
            writer.print(mapentry.getValue() + "\n");  // write the data to an output file
        }
        writer.close();
    }



}