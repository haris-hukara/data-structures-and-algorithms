package main;

import java.util.Comparator;



public class ByCityName implements Comparator<IPAddress> {

	@Override
	public int compare(IPAddress o1, IPAddress o2) {
		
		return o1.cityName.compareTo(o2.cityName);
	}

	
	
}
