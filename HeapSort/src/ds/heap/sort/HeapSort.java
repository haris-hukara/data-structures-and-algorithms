package ds.heap.sort;

import ds.binary.heap.BinaryHeap;
import main.IPAddress;

public class HeapSort {
	
	/* Heap sort algorithm */
	public static void sort(IPAddress [] elements) {
		BinaryHeap<IPAddress> heap = new BinaryHeap<IPAddress>();	// 1
		
		for (int i = 0; i < elements.length; i++) {				// 2
			heap.insert(elements[i]);							// 2
		}
		
		for (int i = elements.length - 1; i >= 0; i--) {		// 3
			elements[i] = heap.delMax();						// 3
		}
	}
}
