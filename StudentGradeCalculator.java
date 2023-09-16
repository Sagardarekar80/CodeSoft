package Task_2;

import java.util.Scanner;

public class StudentGradeCalculator 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Student Grade Calculator ");
		System.out.print("Enter the number of subjects :");
		
		int numSubjects = scanner.nextInt();
		
		if(numSubjects <= 0)
		{
			System.out.println("Please enter valid number of subjects");
			scanner.close();
			return;
		}
		
		double totalMarks = 0.0;
		
		for(int i=1; i<=numSubjects; i++) 
		{
			System.out.print("Enter marks obtained in subject " + i + ":");
			
			double marks = scanner.nextDouble();
		
			if (marks < 0 || marks >100)
			{
				System.out.println("Marks should be between 0 to 100. Please enter valid marks");
				i--;
				continue;
			}
			totalMarks += marks;
		}
		
		double averagePercentage = totalMarks/numSubjects;
		String grade = calculateGrade(averagePercentage);
		
		System.out.println("Results");
		System.out.println("Total Marks : " + totalMarks );
		System.out.println("Average Percentage : " + averagePercentage + "%");
		System.out.println("Grade :" + grade);
		scanner.close();		
	}
		
	public static String calculateGrade(double percentage) 
	{
		if (percentage >=90)
		{
			return "A+" ;
		}else if (percentage >=80)
		{
			return "A" ;
		}else if (percentage >=70)
		{
			return "B" ;
		}else if (percentage >=60)
		{
			return "C" ;
		}else if (percentage >=50)
		{
			return "D" ;
		}else
		{
			return "F";
		}			
	}
	 
	
}
