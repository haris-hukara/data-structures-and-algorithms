package main;

public class IPAddress implements Comparable<IPAddress> {
		long ipFrom;
		long ipTo;
		String countryCode;
		String countryName;
		String regionName;
		String cityName;
	
	public IPAddress( long ipFrom,
					  long ipTo,
					  String countryCode,
					  String countryName,
					  String regionName,
					  String cityName ) {
		  
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionName = regionName;
		this.cityName = cityName;
		
	}
	
	
	
	public int compareTo(IPAddress obj) {
		 
		if (this.ipFrom > obj.ipFrom) {
			return 1;
		}else if(this.ipFrom < obj.ipFrom) {
			return -1;
		}else {
			return 0;
		}
		
	}
	//used for writing CSV
	public String toCommaString() {
	return "\"" 
	+ this.ipFrom + "\",\"" 
	+ this.ipTo + "\"," 
	+ this.countryCode  + "," 
	+ this.countryName  + "," 
	+ this.regionName  + "," 
	+ this.cityName;
}
	
	public String toString() {
	return this.ipFrom + " " 
	+ this.ipTo + " " 
	+ this.countryCode  + " " 
	+ this.countryName  + " " 
	+ this.regionName  + " " 
	+ this.cityName;
}
	
	public String getDetails() {
		return 	  this.countryCode  + " " 
				+ this.countryName  + " " 
				+ this.regionName  + " " 
				+ this.cityName;
	}
	
}
