package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    // IP addreses: 4.72.10.0  
	// Result in CSV -> "71830016","71830271","US","UNITED STATES","DISTRICT OF COLUMBIA","WASHINGTON"
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// paths
		String readPath = "IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		String userInput;

		IPAddress[] ipAddresses = new IPAddress[100]; 			// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 			// read CSV and create objects
	
		Arrays.sort(ipAddresses);					 			// BubbleSort.sort(ipAddresses); sorting
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

	
	} // end of main
		
	
	
	
	// read file and create objects 
	public static void readAndCreate(String readPath, IPAddress[] ipAddresses) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(readPath));
		String line = "";
		
		int i= 0;
		while ((i != ipAddresses.length)) {
			line = br.readLine();

			String[] values = line.split(",");
				
			ipAddresses[i] = new IPAddress(
					Long.parseLong(values[0].replaceAll("\"", "")), 
					Long.parseLong(values[1].replaceAll("\"", "")), 
					values[2], values[3], values[4], values[5]);		
			i++;
		}
	}

	
	// write CSV file
	public static void writeToFile(String writePath, IPAddress[] ipAddresses) throws IOException {
		File file = new File(writePath);
		FileWriter fw = new FileWriter(file);
		int i = 0;
		while ((i != ipAddresses.length)) {
		fw.write(ipAddresses[i].toCommaString() + "\n");
		i++;
		}
		
		fw.close();
		
	}


	// converte
	public static long ipToNum(String ipInput) {
		String userInput = ipInput;
		
		String[] conv = userInput.split("\\.");
		long w = Long.parseLong(conv[0]);
		long x = Long.parseLong(conv[1]);
		long y = Long.parseLong(conv[2]);
		long z = Long.parseLong(conv[3]);
		
		return 16777216 * w + 65536 * x + 256 * y + z;
	}
	
	// converte
	public static String numToIp(String ipNumber) {
		long ipNum = Long.parseLong(ipNumber);
		long w =(ipNum / 16777216) % 256;
		long x =(ipNum / 65536) % 256;
		long y =(ipNum / 256) % 256;
		long z =(ipNum ) % 256;
		
		return w + "." + x + "." + y + "." + z;
	}

}
	



