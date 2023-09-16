package Task_1;

import java.util.Scanner;

public class RandomNumber 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int min;
		System.out.println("Enter minimum range value =");		
		min = scanner.nextInt();
		
		int max;
		System.out.println("Enter maximum range value =");
		max = scanner.nextInt();
		
		System.out.println("Minimum range value =" + min);
		System.out.println("Maximum range value =" + max);
		
		System.out.println("Random number between " + min + "to " + max + ":");
		
		int RandomNumber = (int) (Math.random()* (max-min+1)+ min );
		System.out.print(RandomNumber);
	}

}
