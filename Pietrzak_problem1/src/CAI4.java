import java.security.SecureRandom;
import java.util.Scanner;
public class CAI4 {
	// This function reads the response that the user inputs.
	public static int readResponse()
	{
		Scanner scn = new Scanner(System.in);
		int answer = scn.nextInt();
		return answer;
	}
	// This function displays a random correct response.
	public static void displayCorrectResponse()
	{
		// Generate a random number between 1 and 4, then use a switch to pick a response.
		SecureRandom rand = new SecureRandom();
		int choice = rand.nextInt(4) + 1;
		switch (choice){
			case 1: System.out.println("Very good!");
					break;
			case 2: System.out.println("Excellent!");
					break;
			case 3: System.out.println("Nice work!");
					break;
			case 4: System.out.println("Keep up the good work!");
					break;
		}
	}
	// This function displays a random incorrect response.
	public static void displayIncorrectResponse()
	{
		// Generate a random number between 1 and 4, then use a switch to pick a response.
		SecureRandom rand = new SecureRandom();
		int choice = rand.nextInt(4) + 1;
		switch(choice) {
			case 1: System.out.println("No. Please try again.");
					break;
			case 2: System.out.println("Wrong. Try once more.");
					break;
			case 3: System.out.println("Don't give up!");
					break;
			case 4: System.out.println("No. Keep trying.");
					break;
		}
	}
	// Ask the user a question using two integers.
	public static void askQuestion(int num1, int num2)
	{
		System.out.println("What is " + num1 + " times " + num2 + "?");
	}
	// This function runs all the functions, except the main function, to create the quiz.
	public static void quiz()
	{
		// Create the integers.
		int num1, num2, answer, difficulty, counter = 0;
		int response = 1;
		// Loop through the program while the user chooses to do so.
		while(response == 1)
		{
			// Prompt the user to enter a difficulty level between 1 and 4.
			System.out.println("Please enter a difficulty level between 1 and 4: ");
			difficulty = readDifficulty();
			// Loop through the program in order to produce 10 different problems for the user to solve.
			for(int i = 0; i < 10; i++)
			{
				// Generate two random numbers using the difficulty as a parameter.
				num1 = generateQuestionArgument(difficulty);
				num2 = generateQuestionArgument(difficulty);
				// Ask the user a random math question using the two numbers.
				askQuestion(num1, num2);
				// Read the user's input for their answer.
				int userInput = readResponse();
				// Find the actual answer.
				answer = num1 * num2;
				// Check if the answer is correct or not. If so, add a point to the counter.
				if(isAnswerCorrect(userInput, answer))
				{
					displayCorrectResponse();
					counter++;
				}
				else
				{
					displayIncorrectResponse();
				}
			}
			// Display a completion message using the counter.
			displayCompletionMessage(counter);
			// Ask the user if they would like to try again.
			System.out.println("Would you like to try again? 1 for yes, 2 for no.");
			response = readResponse();
		}
	}
	// This function checks if the answer is correct by checking if the input and answer equal each other.
	public static boolean isAnswerCorrect(int input, int answer)
	{
		if(input == answer)
			return true;
		else
			return false;
	}
	// This function displays the completion message using the score as a parameter.
	public static void displayCompletionMessage(int score)
	{
		// If the score is less than 8, then say the student needs extra help. If greater or equal to, congratulate them.
		if(score < 8)
			System.out.println("Please ask your teacher for extra help.\n");
		else
			System.out.println("Congratulations, you are ready to go to the next level!\n");
	}
	// This function reads the difficulty level of the problem.
	public static int readDifficulty()
	{
		int level = readResponse();
		return level;
	}
	// This function generates a random number based on the difficulty level.
	public static int generateQuestionArgument(int level)
	{
		// Initialize a random number.
		SecureRandom rand = new SecureRandom();
		int num = 0;
		// Use a switch determined by the level. If 1, generate 0-9. If 2, 0-99. If 3, 0-999, and so on.
		switch(level)
		{
		case 1: num = rand.nextInt(10);
				break;
		case 2: num = rand.nextInt(100);
				break;
		case 3: num = rand.nextInt(1000);
				break;
		case 4: num = rand.nextInt(10000);
				break;
		}
		// Return the random number generated.
		return num;
	}

	public static void main(String[] args) {
		quiz();
	}

}