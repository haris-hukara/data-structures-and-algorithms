package iterativeMergeSort;
import java.io.IOException;
import main.AbstractSort;
import main.ByCityName;
import main.IPAddress;

public class Main extends AbstractSort {

	public static void main(String[] args) throws IOException {
		
		// paths
		String readPath = "C:\\Users\\Haris\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv"; 
		String writePath = "write.txt";
		
		
		IPAddress[] ipAddresses = new IPAddress[100]; 				// works with larger array size
		readAndCreate(readPath, ipAddresses); 		 				// read CSV and create objects
		
				
		long s = System.currentTimeMillis();
		IterativeMergeSort.sort(ipAddresses, new ByCityName()); 
       // IterativeMergeSort.sort(ipAddresses); 
        
		System.out.println(System.currentTimeMillis() - s);			// 1.5 - 2.5 sec for 1 Million
		writeToFile(writePath, ipAddresses);


	}

}
