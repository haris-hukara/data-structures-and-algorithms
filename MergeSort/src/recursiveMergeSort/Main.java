package recursiveMergeSort;

import java.io.IOException;

import main.AbstractSort;
import main.ByCityName;
import main.IPAddress;

public class Main extends AbstractSort {

	public static void main(String[] args) throws IOException {
		
		// paths
		String readPath = "IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		
		
		IPAddress[] ipAddresses = new IPAddress[10]; 			// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
		
		
		long s = System.currentTimeMillis();
	//	RecursiveMergeSort.sort(ipAddresses, new ByCityName()); 	 
	 	RecursiveMergeSort.sort(ipAddresses); 
	 		 	
	 	System.out.println(System.currentTimeMillis() - s);			// 1.5 - 2.5 sec for 1 Million
		writeToFile(writePath, ipAddresses);

	}

}
