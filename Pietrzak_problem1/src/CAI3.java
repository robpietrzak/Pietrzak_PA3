import java.security.SecureRandom;
import java.util.Scanner;
public class CAI3 {
	// This function read's the user's response.
	public static int readResponse()
	{
		Scanner scn = new Scanner(System.in);
		int answer = scn.nextInt();
		return answer;
	}
	// This function displays a random correct response.
	public static void displayCorrectResponse()
	{
		// Generate a random number between 1 and 4, and use that number to find a correct response to display.
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
	// This function displays an incorrect response.
	public static void displayIncorrectResponse()
	{
		// Create a random number between 1 and 4, then choose a reponse assigned to that number from the switch.
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
	// Ask the user a random question using two numbers as inputs.
	public static void askQuestion(int num1, int num2)
	{
		System.out.println("What is " + num1 + " times " + num2 + "?");
	}
	// This function creates the quiz and utilizes all other functions except for main.
	public static void quiz()
	{
		// Create integers
		int userInput, counter = 0;
		int answer, response = 1;
		// Loop through the program while the user wants to continue using it.
		while(response == 1)
		{
			// Generate ten random questions for the user to solve.
			for(int i = 0; i < 10; i++)
			{
				// Generate two random single digit numbers using SecureRandom.
				SecureRandom random = new SecureRandom();
				int rand1 = random.nextInt(10);
				int rand2 = random.nextInt(10);
				// Call upon the askQuestion function using rand1 and rand2.
				askQuestion(rand1, rand2);
				// Read the user's input.
				userInput = readResponse();
				// Multiply the two random numbers together to get the actual answer
				answer = rand1 * rand2;
				// Check if the answer is correct by calling upon the isAnswerCorrect function.
				if(isAnswerCorrect(userInput, answer))
				{
					// Display a correct response and add one point to the counter.
					displayCorrectResponse();
					counter++;
				}
				else
				{
					displayIncorrectResponse();
				}
			}
			// Display a completion message using the value that the counter has.
			displayCompletionMessage(counter);
			// Ask the user if he or she would like to try again
			System.out.println("Would you like to try again? 1 for yes, 2 for no.");
			response = readResponse();
		}
	}
	// This function compares two numbers to see if they equal each other.
	public static boolean isAnswerCorrect(int input, int answer)
	{
		if(input == answer)
			return true;
		else
			return false;
	}
	// This function displays one of two completion messages, depending on their score.
	public static void displayCompletionMessage(int score)
	{
		// Check if the student scored at least a 75 percent. Since we are dealing with 10 integers, any 
		// integer > 8/10 is treated as lower than 75 percent.
		if(score < 8)
			System.out.println("Please ask your teacher for extra help.\n");
		else
			System.out.println("Congratulations, you are ready to go to the next level!\n");
	}

	public static void main(String[] args) {
		quiz();
	}

}
