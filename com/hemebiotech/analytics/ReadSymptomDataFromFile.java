package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 * @param filepath a full or partial path to file with symptom strings in it, one per line
 */
public record ReadSymptomDataFromFile(String filepath) implements ISymptomReader {

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> symptomsList = new ArrayList<String>(); // add symptoms in a arraylist from a file
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {
					symptomsList.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return symptomsList;
	}

	@Override
	public int CountSymptoms(String symptom) {
		int occurrences = 0; // count the number of occurrences of the symptom
		for (int i = 0; i < this.GetSymptoms().size(); i++) {
			if (this.GetSymptoms().get(i).equals(symptom)) {
				occurrences++;
			}
		}
		return occurrences;
	}
}