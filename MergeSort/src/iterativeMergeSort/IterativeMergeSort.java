package iterativeMergeSort;


import java.util.Comparator;
import main.IPAddress;

public class IterativeMergeSort {
	
	public static void sort(IPAddress[] elements) {
		sort(elements, null);
	}
	
	public static void sort(IPAddress[] elements, Comparator<IPAddress> comparator ) {
		
		IPAddress[] aux = new IPAddress[elements.length];										
		for (int size = 1; size < elements.length; size *= 2) {						
			for (int low = 0; low < elements.length - size; low += 2 * size) {		
				int mid = low + size - 1;											
				int high = Math.min(low + 2 * size - 1, elements.length - 1);		
			
					if (comparator != null) {
					merge(elements, aux, low, mid, high, comparator);													}
				else if(comparator == null) {
					merge(elements, aux, low, mid, high, null);
					}
			}
		}
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

		}else if ( j > high ) {							// no more elements at right side array
				elements[k]= aux[i++];
			
		
		}else if (comparator == null) {
				if (aux[j].compareTo(aux[i]) < 0) 		// if element at right array(j) < than element at left(i) return -1
				elements[k]= aux[j++];					// take that element and move it
				else {									// if element at left(i) array is < than element at right(j)
				elements[k]= aux[i++];					// leave as it is	
				}
		}
			
		else if (comparator != null) {
			 	if (comparator.compare(aux[j],aux[i]) < 0)	
				elements[k]= aux[j++];					
			 	else {										
				elements[k]= aux[i++];					
			}
		}
			
		}
		
		}

	}
	
	
		

	

