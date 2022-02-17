package selectionSort;

import java.io.IOException;
import main.AbstractSort;
import main.IPAddress;

public class Main extends AbstractSort{

	public static void main(String[] args) throws IOException {


		// paths
		String readPath = "C:\\Users\\Haris\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		

		IPAddress[] ipAddresses = new IPAddress[10]; 			// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
	
		// BubbleSort.sort(ipAddresses); sorting
		SelectionSort.sort(ipAddresses);
		writeToFile(writePath, ipAddresses); 

		
	}

}
