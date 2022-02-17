package main;

public class BinarySearch {

	/* Binary search algorithm for integer arrays */
	public static int search(long[] elements1, long[] elements2, long target) {
//		                            first IPs 	      lastIPs 
		int low = 0;	
		int high = elements1.length - 1;					
		
		while (low <= high) {							
			int mid = low + (high - low) / 2;			
			if (target < elements1[mid])  {				
				high = mid - 1;							
			} else if (target > elements2[mid]) {		
				low = mid + 1;							
			} else if (target >= elements1[mid] && target <= elements2[mid]) {									
				return mid;								
			}
		}
		return -1;										
	}	
	
	
}

