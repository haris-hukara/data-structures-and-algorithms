package insertionSort;

import main.AbstractSort;

public class InsertionSort extends AbstractSort{
	
	@SuppressWarnings("unchecked")
	public static void sort(Comparable[] elements) {
		
		for(int i = 0; i < elements.length; i++) {
			for(int j = i; j > 0; j--) {   	   
				if (  elements[j].compareTo(elements[j -1]) < 0)  { 
				                                  	   
					swap(elements, j, j - 1);
				}else {
					break;
				}
			}
		}
		
	}

}
