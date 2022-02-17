package shellSort;

import java.io.IOException;

import main.AbstractSort;
import main.IPAddress;

public class Main extends AbstractSort {

	public static void main(String[] args) throws IOException {

		// paths
		String readPath = "IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		
		
		IPAddress[] ipAddresses = new IPAddress[10]; 			// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
		
				
		ShellSort.sort(ipAddresses); 
		writeToFile(writePath, ipAddresses);

	}

}
