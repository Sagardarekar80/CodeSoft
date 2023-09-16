package Task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication 
{
	private static List<Question> questions = new ArrayList<>();
	private static int currentQuestionIndex = 0;
	private static int score = 0;
	
	
	public static void main(String[] args) 
	{		
		questions.add(new Question ("What is the capital of France?", List.of("A. London", "B. Paris", "C. Berlin", "D. Medrid"), 1));
		
		questions.add(new Question ("What is 2 + 2?", List.of("A. 3", "B. 4", "C. 5", "D. 6"), 1));
		
		questions.add(new Question ("Which planet known as Red planet?", List.of("A. Earth", "B. Mars", "C. Venus", "D. Jupiter"), 1));
		
		
		System.out.println("Welcome to the Quiz Application!");		
		startQuiz();
		
	}
	
	public static void startQuiz()
	{
		if(currentQuestionIndex < questions.size())
		{
			Question currentQuestion = questions.get(currentQuestionIndex);
			System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestionText() );
			
			for (String option : currentQuestion.getOptions())
			{
				System.out.println(option);
			}
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					System.out.println("Time's up! Moving to the next question.");
					currentQuestionIndex++;
					timer.cancel();
					startQuiz();
				}
				
				
			},15000);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your answer (A, B, C, or D): ");
			String userAnswer = scanner.nextLine().toUpperCase();
			
			timer.cancel();
			
			if (userAnswer.equals(currentQuestion.getOptions().get(currentQuestion.getCorrectOption()).substring(0, 1)))
			{
				System.out.println("Correct");
				score++;
			}else
			{
				System.out.println("Incorrect");
			}
			
			currentQuestionIndex++;
			startQuiz();						
		}else
		{
			System.out.println("Quiz ended");
			System.out.println("Your score: " + score + "out of " + questions.size());
			
			for (int i = 0; i < questions.size(); i++)
			{
				Question q = questions.get(i);
				String result = "Incorrect";
				if (i < score)
				{
					result = "Correct";
				}
				System.out.println("Question " + (i+1) + ": " + q.getQuestionText() + " - " + result);
			}	
		}		
	}
	
	

}
