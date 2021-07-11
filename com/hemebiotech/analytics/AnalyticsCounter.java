package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		/* declaration de TreeMap */
		TreeMap tm = new TreeMap();


		while (line != null) {
			//System.out.println("Symptom : " + line);
			int i = 1;
			String tmp = line;

			while (line != null){
				if(line == tmp){
					i++;
				}
				line = reader.readLine();	// get another symptom
			}

			/*Ajouter des éléments à TreeMap*/
			tm.put(i, tmp);

			line = reader.readLine();	// get another symptom

		}

		/* Afficher le contenu en utilisant Iterator */
		Set set = tm.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry)iterator.next();
			System.out.print("clé: "+ mapentry.getKey() + " - valeur: " + mapentry.getValue() + "\n");
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.close();



	}
}
