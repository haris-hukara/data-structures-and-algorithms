package radixSort;

import main.IPAddress;

public class RadixSort {

	/* Radix sort algorithm (public invocation) */
	public static void sort(IPAddress[] elements) {
		IPAddress max = getMax(elements);									// 1
		
		for (int exp = 1; max.ipFrom / exp > 0; exp *= 10) {				// 2
			sort(elements, exp);											// 3
		}
	}

	/* Digit-wise radix sort logic */
	private static void sort(IPAddress[] elements, int exp) {
		IPAddress[] aux = new IPAddress[elements.length];					// 1
		int[] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};					// 2
		
		for (int i = 0; i < elements.length; i++) {							// 3
			int digit = (int) ((elements[i].ipFrom / exp) % 10);			// 3
			frequency[digit]++;												// 3
		}
		
		for (int i = 1; i < 10; i++) {										// 4
			frequency[i] += frequency[i - 1];								// 4
		}
		
		for (int i = elements.length - 1; i >= 0; i--) {					// 5
			int digit = (int) ((elements[i].ipFrom / exp) % 10);			// 5
			aux[frequency[digit] - 1] = elements[i];						// 5
			frequency[digit]--;												// 5
		}
		
		for (int i= 0; i < elements.length; i++) {							// 6
			elements[i] = aux[i];											// 6
		}
	}
	
	/* Find the maximum element in the array */
	private static IPAddress getMax(IPAddress[] elements) {
		IPAddress max = elements[0];										// 1
		for (int i = 1; i < elements.length; i++) {							// 2
			if (elements[i].compareTo(max) > 0) {							// 3
				max = elements[i];											// 3
			}
		}
		return max;															// 4
	}
}