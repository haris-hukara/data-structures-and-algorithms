package main;

public class Student {
	
		public int studentID;
		public String fullName;
		public String birthDate;
		public String universityName;
		public String departmentCode;
		public String departmentName;
		public int enrolmentYear;

	public Student (int studentID, 
					String fullName,
					String birthDate,
					String universityName, 
					String departmentCode,
					String departmentName, 
					int enrolmentYear) {
		
		this.studentID = studentID;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.universityName = universityName;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.enrolmentYear = enrolmentYear;
	
	}

	public String toCommaString() {
		
	return + this.studentID 		+	";"   
		   + this.fullName 			+   ";"
		   + this.birthDate  		+   ";"
		   + this.universityName  	+   ";"
		   + this.departmentCode   	+   ";"
		   + this.departmentName	+	";"
		   + this.enrolmentYear;
}

	public String getDetails() {
	      return  "\n  Student ID: " 	         +  this.studentID
				+ "\n  Name and surname: "   +  this.fullName
				+ "\n  Date of birth: " 	 +  this.birthDate
				+ "\n  University: "		 +  this.universityName
				+ "\n  Department code: "    +  this.departmentCode
				+ "\n  Department: " 	     +  this.departmentName
				+ "\n  Year of enrolment: "  +  this.enrolmentYear
				+ "\n";
	}

	
}
