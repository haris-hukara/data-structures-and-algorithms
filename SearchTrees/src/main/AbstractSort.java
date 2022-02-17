package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractSort {
		
	

	@SuppressWarnings("rawtypes")
	public static void swap(Comparable[] elements, int i, int min) {
		Comparable tmp = elements[i];
		elements[i] = elements[min];
		elements[min] = tmp;
	}
	
	
	
	
	// read file and create objects 
	public static void readAndCreate(String readPath, Student[] student) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(readPath));
		String line = "";
		
		int i= 0;
		while ((i != student.length)) {
			line = br.readLine();

			String[] values = line.split(";");
				
			student[i] = new Student(Integer.parseInt(values[0]), 
													  values[1],
													  values[2],
													  values[3],
													  values[4],
													  values[5],
									 Integer.parseInt(values[6]));
			i++;
		}
	
		br.close();
	}

	

	

	
	
}
