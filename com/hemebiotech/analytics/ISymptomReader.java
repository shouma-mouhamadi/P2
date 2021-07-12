package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 *
 * @author shouma-mouhamadi
 * 
 */
public interface ISymptomReader {
	/**
	 * Add symptoms in a arraylist from a file
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> GetSymptoms ();

	/**
	 * Count the number of occurrences of the symptom
	 * If the symptom does not exist, the function returns 0
	 *
	 * @param symptom the name of the symptom whose number of occurrences must be found
	 * @return the number of occurrences of a string in a list
	 */
	int CountSymptoms(String symptom);
}