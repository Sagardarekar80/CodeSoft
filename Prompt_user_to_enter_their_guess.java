package Task_1;

import java.util.Random;
import java.util.Scanner;

public class Prompt_user_to_enter_their_guess 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int min = 1;
		int max = 100;
		int maxAttempts = 10;
		int roundsPlayed = 0;
		int totalAttempts = 0;
		int bestScore = Integer.MAX_VALUE;
		
		boolean playAgain = true;
		
		System.out.println("Welcome to the number guessing game !");
		System.out.println("Yau have" + maxAttempts + "attempts to guess the number between " + min + " and " + max + ".");
		
		while (playAgain)
		{
			int RandomNumber = random.nextInt(max-min+1) + min;			
			int attempts = 0;
			
			boolean hasGuessCorrectly = false;
			System.out.println(" Round " + (roundsPlayed + 1) + ":");
			
			while (! hasGuessCorrectly && attempts < maxAttempts)
			{
				System.out.println("Attempts " + (attempts+1) + " / " + maxAttempts + " Enter your guess:");
				
				int userGuess = scanner.nextInt();
				attempts++;
				
				if(userGuess < min || userGuess > max)
				{
					System.out.println("Please guess a number between " + min + " and " + max+ ".");
				}else if(userGuess < RandomNumber)
				{
					System.out.println("Too low ! Try again.");
				}else if(userGuess > RandomNumber)
				{
					System.out.println("Too high ! Try again.");
				}
				else
				{
					hasGuessCorrectly = true;
					System.out.println("Congratulation ! You have guessed correct number " + RandomNumber + " Correctly in " + attempts + " attempts. " );
					
					totalAttempts += attempts;
					
					if(attempts < bestScore)
					{
						bestScore = attempts;
					}
					
				}
			}
			
			if(!hasGuessCorrectly)
			{
				System.out.println("Sorry you have used all your attempts. The number was " + RandomNumber + ".");
			}
			
			System.out.println("Your current best score is " + bestScore + " attempts.");
			
			System.out.println("Do you want to play again? (yes/no) :");
			
			String playAgainResponse = scanner.next().toLowerCase();
			
			if(! playAgainResponse.equals("yes"))
			{
				playAgain = false;
			}
			roundsPlayed ++;			
		}
		
		System.out.println("Game over ! You played " + roundsPlayed + " rounds with an average of " + (totalAttempts/roundsPlayed)+ " attemps per round. ");
		scanner.close();		
	}

}
