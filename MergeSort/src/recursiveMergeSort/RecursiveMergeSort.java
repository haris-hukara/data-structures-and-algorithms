package recursiveMergeSort;

import java.util.Comparator;

import main.IPAddress;

public class RecursiveMergeSort {
		
	public static void sort(IPAddress[] elements) {
		sort(elements, null);
	}
	
	public static void sort(IPAddress[] elements, Comparator<IPAddress> comparator ) {
	
	IPAddress[] aux = new IPAddress[elements.length];	
	sort(elements, aux, 0, elements.length - 1, comparator);
	
	}
	
	private static void sort(IPAddress[] elements, IPAddress[]aux, int low, int high, Comparator<IPAddress> comparator) {
		if (high <= low) {
			return;
		}
	int mid = low + (high - low) / 2;							// finding mid
	sort(elements, aux, low, mid, comparator); 					// 1st half sort
	sort(elements, aux, mid + 1, high, comparator); 			// 2nd half sort
	merge(elements, aux, low, mid, high, comparator);			
	
	}
	
	private static void merge(IPAddress[]elements, IPAddress[]aux, int low, int mid, int high, Comparator<IPAddress> comparator) {
	
		for (int k = low; k <= high; k++) {				// creating helper/aux array
			aux[k] = elements[k];						// copy data from original array to aux
		}
		
		int i = low;									// pointer to left array
		int j = mid + 1;								// pointer to right array
		
		for (int k = low; k <= high; k++) {
			
			if (i > mid) {								// no more elements at left side array
				elements[k]= aux[j++];					

			} else if ( j > high ) {					// no more elements at right side array
				elements[k]= aux[i++];
			}
			
			else if (comparator == null) {
			if (aux[j].compareTo(aux[i]) < 0) 				// if element at right array is smaller than element at left
				elements[k]= aux[j++];						// take that element and move it
			else 											// if element at left array is smaller than element at right
				elements[k]= aux[i++];						// leave 
			}
			
			else if( comparator != null) {
				if ( comparator.compare(aux[j],aux[i]) < 0) 			// if element at right array is smaller than element at left
					elements[k]= aux[j++];								// take that element and move it
				else 													// if element at left array is smaller than element at right
					elements[k]= aux[i++];								// leave 
				}
		 }
}



}
