package redBlackTree;

import java.io.IOException;
import main.AbstractSort;
import main.Student;
import java.util.Scanner;



public class Main extends AbstractSort {

	public static void main(String[] args) throws IOException  {
		
		// first 10 IDs    BST      RBT
		// 2063092          1        1          
		// 1064989          2        2     
		// 3059703          2        2              
		// 2082031          3        3                              
		// 9065345          3        3                             
		// 7090334          4        3                             
		// 1053337          3        3                  
		// 4048962          5        3                 
		// 11055905         4        3                   
		// 7060127          6        3          
		
		// 12               4        3                   
        // 999999999		         3
		
		String readPath = "C:\\Users\\Haris\\Desktop\\Global_University_Students.csv"; 

		
		Student[] students = new Student[3]; 	     		// works with larger array size
		readAndCreate(readPath, students); 		 			// read CSV and create objects
		
		RedBlackTree<Integer, Student> rbt = new RedBlackTree<Integer, Student>();
		
		int i = 0;
		
		while ((i != students.length)) {
			rbt.put(students[i].studentID, students[i]);
			i++;
		}
		
		Scanner scan = new Scanner(System.in);
		int userInput;
		
		System.out.print("Enter the ID of the student you want to retrive: ");
		userInput = scan.nextInt();
		
		if (rbt.get(userInput) == null) {
			System.out.println("The student with the given ID does not exist.");
			rbt.get(userInput);
			System.out.println(rbt.getStepCount());
		}else {
			System.out.println(rbt.get(userInput).getDetails()); 			
			System.out.println(rbt.getStepCount());
		}
		


	}


	

}
