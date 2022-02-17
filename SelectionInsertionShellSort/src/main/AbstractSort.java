package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractSort {
		
	

	@SuppressWarnings("rawtypes")
	public static void swap(Comparable[] elements, int i, int min) {
		// TODO Auto-generated method stub
		Comparable tmp = elements[i];
		elements[i] = elements[min];
		elements[min] = tmp;
	}
	
	
	
	
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
	

		// converter
		public static long ipToNum(String ipInput) {
			String userInput = ipInput;
			
			String[] conv = userInput.split("\\.");
			long w = Long.parseLong(conv[0]);
			long x = Long.parseLong(conv[1]);
			long y = Long.parseLong(conv[2]);
			long z = Long.parseLong(conv[3]);
			
			return 16777216 * w + 65536 * x + 256 * y + z;
		}
		
		// converter
		public static String numToIp(String ipNumber) {
			long ipNum = Long.parseLong(ipNumber);
			long w =(ipNum / 16777216) % 256;
			long x =(ipNum / 65536) % 256;
			long y =(ipNum / 256) % 256;
			long z =(ipNum ) % 256;
			
			return w + "." + x + "." + y + "." + z;
		}
	
	
}
