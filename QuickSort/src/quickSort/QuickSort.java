package quickSort;

import java.util.Comparator;
import java.util.Random;

import main.AbstractSort;
import main.IPAddress;

public class QuickSort extends AbstractSort{

	
	/* Quick sort algorithm (public invocation) */
	public static void sort(IPAddress[] elements ) {
		sort(elements, null);
	}
	
	public static void sort(IPAddress[] elements, Comparator<IPAddress> comparator ) {
		shuffle(elements);		
		if(comparator == null) {
		sort(elements, 0, elements.length - 1, null);		
		
		}else {
		
		sort(elements, 0, elements.length - 1, comparator);
		}
	
	}
	
	/* Knuth shuffle (performance guarantee) */
	private static void shuffle(IPAddress[] elements) {
		Random rand = new Random();							
		for (int i = 0; i < elements.length; i++) {			
			int r = i + rand.nextInt(elements.length - i);
			swap(elements, i, r);						
		}
	}
	
	/* Recursive quick sort logic */
	private static void sort(IPAddress[] elements, int low, int high, Comparator<IPAddress> comparator) {
		if (high <= low) {								
			return;										
		}
		
		if(comparator == null) {
			int j = partition(elements, low, high, null);			
			sort(elements, low, j - 1, null);						
			sort(elements, j + 1, high, null);						
		
		}else {
			
			int j = partition(elements, low, high, comparator);			
			sort(elements, low, j - 1, comparator);						
			sort(elements, j + 1, high, comparator);					
		}
		
	}
	
	/* Partition an array and return the pivot index */
	private static int partition(IPAddress[] elements, int low, int high, Comparator<IPAddress> comparator) {
		int i = low;															
		int j = high + 1;														
		if (comparator == null) {
			while (true) {														
				while ( ( elements[++i].compareTo(elements[low]) ) < 0) {		
					if (i == high) {											
						break;													
					}
				}
				while ( ( elements[low].compareTo(elements[--j]) ) < 0) {		
					if (j == low) {												
						break;													
					}
				}
				if (i >= j) {													
					break;														
				}
				swap(elements, i, j);											
			}
		
		} else {
			
			while (true) {															
				while ( comparator.compare(elements[++i], elements[low]) < 0) {		
					if (i == high) {												
						break;														
					}
				}
				while ( comparator.compare(elements[low], elements[--j]) < 0 ) {	
					if (j == low) {													
						break;														
					}
				}
				if (i >= j) {										
					break;											
				}
				swap(elements, i, j);							
			}	

		}
		
		
		swap(elements, low, j);									
		return j;												
	}
	
	
}
