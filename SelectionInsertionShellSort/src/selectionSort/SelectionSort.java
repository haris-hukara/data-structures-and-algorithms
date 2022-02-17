package selectionSort;

import main.AbstractSort;


public class SelectionSort extends AbstractSort {
	
	@SuppressWarnings("unchecked")
	public static void sort(Comparable[] elements) {
		
		for(int i = 0; i < elements.length; i++) {
			int min = i;
			for(int j = i + 1; j < elements.length; j++ ) {   	   // j = i + 1 because left part is sorted 
				if (  elements[j].compareTo(elements[min]) < 0)  { // if j is less then min comperTo returns -1
					min = j;                                  	   // update min if element j is less then current min
				}
			}
			swap(elements, i, min);
		}
		
	}
	
	
	/*
	
		@SuppressWarnings("rawtypes")
	public static void swap(Comparable[] elements, int i, int min) {
			Comparable tmp = elements[i];
			elements[i] = elements[min];
			elements[min] = tmp;
		}
}  
	  
	  */
}
		


	

