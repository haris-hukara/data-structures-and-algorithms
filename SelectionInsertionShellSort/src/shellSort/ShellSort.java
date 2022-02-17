package shellSort;

import main.AbstractSort;
import main.IPAddress;

public class ShellSort extends AbstractSort {

	
	@SuppressWarnings("unchecked")
	public static void sort(Comparable[] elements) {
		int h = 1; 											 
		while (h < elements.length / 3){ 		// searching for biggest constant for our array
		h= 3* h + 1;
		}
		
		while (h >= 1) {													
			for (int i = h; i < elements.length; i++) {
				for (int j = i; j >= h ; j -= h) {
					if (elements[j].compareTo(elements[j -1]) < 0) {
						swap( elements , j , j - h );
					} else {
						break;
					} 
				}
			}
			h = h/3;							// cutting h by 3 in each iteration 
		}
}
	}
