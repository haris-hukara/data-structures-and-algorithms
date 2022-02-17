package radixSort;

import java.io.IOException; 

import main.AbstractSort;
import main.IPAddress;

public class Main extends AbstractSort{

	public static void main(String[] args) throws IOException {

				// paths
				String readPath = "C:\\Users\\Haris\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
				String writePath = "write.txt";
				

				IPAddress[] ipAddresses = new IPAddress[100]; 			// works with larger array size
				readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
			
				
		 		RadixSort.sort(ipAddresses);				 			// sort by IPs
				writeToFile(writePath, ipAddresses); 		 			// writing to new CSV
				
	}

}
