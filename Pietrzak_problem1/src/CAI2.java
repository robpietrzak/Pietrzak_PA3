import java.security.SecureRandom;
import java.util.Scanner;
public class CAI2 {
	// This function reads the user's response.
	public static int readResponse()
	{
		Scanner scn = new Scanner(System.in);
		int answer = scn.nextInt();
		return answer;
	}
	// This function displays a random correct response.
	public static void displayCorrectResponse()
	{
		// Generate a random number between 1 and 4
		SecureRandom rand = new SecureRandom();
		int choice = rand.nextInt(4) + 1;
		// Make a switch that uses the random input to generate a random correct response.
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
		// Generate a random number between 1 and 4
		SecureRandom rand = new SecureRandom();
		int choice = rand.nextInt(4) + 1;
		// Assign a response using a switch and the random number.
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
	// This function asks the user a random multiplication question using two numbers.
	public static void askQuestion(int num1, int num2)
	{
		System.out.println("What is " + num1 + " times " + num2 + "?");
	}
	// This function holds all the other functions that makes the quiz run.
	public static void quiz()
	{
		// initialize all the integers and SecureRandom.
		int userInput;
		int answer;
		SecureRandom random = new SecureRandom();
		// Generate two single digit numbers.
		int rand1 = random.nextInt(10);
		int rand2 = random.nextInt(10);
		// Call upon the askQuestion function using rand1 and rand2.
		askQuestion(rand1, rand2);
		// Read the user's response for the input.
		userInput = readResponse();
		// Find the actual answer of the problem.
		answer = rand1 * rand2;
		// Check if the answer is correct or incorrect, then display the message that reflects the user's input.
		if(isAnswerCorrect(userInput, answer))
		{
			displayCorrectResponse();
		}
		else
		{
			while(!isAnswerCorrect(userInput, answer))
			{
				displayIncorrectResponse();
				userInput = readResponse();
			}
			displayCorrectResponse();
		}
	}
	// This function checks the input and the answer if they are equal to each other.
	public static boolean isAnswerCorrect(int input, int answer)
	{
		if(input == answer)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		quiz();
	}

}

