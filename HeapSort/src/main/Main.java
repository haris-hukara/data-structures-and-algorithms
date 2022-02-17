package main;

import java.io.IOException;
import ds.heap.sort.HeapSort;


public class Main extends AbstractSort {

	public static void main(String[] args) throws IOException {

		String readPath = "C:\\Users\\Haris\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		

		IPAddress[] ipAddresses = new IPAddress[100]; 			// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
	
					
		HeapSort.sort(ipAddresses);								// sort
		writeToFile(writePath, ipAddresses);					// write
		
	}

}



