package com.hemebiotech.analytics;

import java.util.*;

public class OrganiseData {

    public ReadSymptomDataFromFile Data;

    public OrganiseData(ReadSymptomDataFromFile AnalyseData) {
        this.Data = AnalyseData;
    }

    public TreeMap formalize(){
        /* declaration de TreeMap */
        TreeMap tm = new TreeMap();

        for (int i=0 ; i < Data.GetSymptoms().size() ; i++){
            tm.put(i, Data.GetSymptoms().get(i) + " - " + Data.CountSymptoms(Data.GetSymptoms().get(i)));
        }
        return tm;
    }

    public void afficher(){
        /* Afficher le contenu en utilisant Iterator */
        Set set = this.formalize().entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry)iterator.next();
            System.out.print("clé: "+ mapentry.getKey() +  " - valeur: "+mapentry.getValue()+"\n");
        }
    }


}
