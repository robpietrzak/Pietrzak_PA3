import java.security.SecureRandom;
import java.util.Scanner;
public class CAI1 {
	
	public static int readResponse()
	{
		/* Initialize a scanner, read the answer, then return the answer.*/
		Scanner scn = new Scanner(System.in);
		int answer = scn.nextInt();
		return answer;
	}
		/* This function displays a correct response. */
	public static void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
		/* This function displays an incorrect response. */
	public static void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
		/* This function asks a question using two numbers. */
	public static void askQuestion(int num1, int num2)
	{
		System.out.println("What is " + num1 + " times " + num2 + "?");
	}
	
	public static void quiz()
	{
		// Create integers and a SecureRandom variable.
		int userInput;
		int answer;
		SecureRandom random = new SecureRandom();
		int rand1 = random.nextInt(10);
		int rand2 = random.nextInt(10);
		// Ask the user a math question.
		askQuestion(rand1, rand2);
		// Read the user's response.
		userInput = readResponse();
		// Find the answer by multiplying the two random numbers.
		answer = rand1 * rand2;
		// Check if the user's input is correct. If so, display correct response. If not, display incorrect response.
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
	// Check if the answer is correct by checking if the answer and input is correct.
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
