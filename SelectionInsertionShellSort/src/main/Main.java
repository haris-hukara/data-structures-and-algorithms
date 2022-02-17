package main;

import java.io.IOException;
import java.util.Scanner;


public class Main extends AbstractSort {

    // IP address: 4.72.10.0  
	// Result in CSV -> "71830016","71830271","US","UNITED STATES","DISTRICT OF COLUMBIA","WASHINGTON"
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// paths
		String readPath = "IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		String userInput;

		IPAddress[] ipAddresses = new IPAddress[50]; 			// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
	
		BubbleSort.sort(ipAddresses); 
		writeToFile(writePath, ipAddresses); 		 			// writing to new CSV

		
		// arrays for finding id of provided ip 
		long[] firstIPs = new long[ipAddresses.length];
		long[] lastIPs = new long[ipAddresses.length];
		
		int i = 0;
		while(i != ipAddresses.length ) {
		firstIPs[i] = ipAddresses[i].ipFrom;
		lastIPs[i] = ipAddresses[i].ipTo;
		i++;
		}
		
//		System.out.println(Arrays.toString(firstIPs));
//		System.out.println(Arrays.toString(lastIPs));
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an IP address: ");	 
		userInput = scan.nextLine();									 // getUserInput
		long userIP = ipToNum(userInput);								 // store converted value
		
		int result = BinarySearch.search(firstIPs, lastIPs, userIP);	 // Search and store ID
		
		// final output
		if( result > -1) {
			System.out.println(	ipAddresses[result].getDetails());
		}else {
			System.out.println("Data not found !");
		}

	
	} 
		
	
	


}
	



