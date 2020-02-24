import java.security.SecureRandom;
import java.util.Scanner;
public class CAI5 {
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
		// Choose a random number between 1 and 4, and use that number to pick a random response.
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
		// Choose a random number between 1 and 4, and use that number to pick a random response.
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
	// This function asks the user a random question determined by the type of question it is.
	public static void askQuestion(int num1, int num2, int type, int option)
	{
		switch(type)
		{
		case 1: System.out.println("What is " + num1 + " plus " + num2 + "?");
				break;
		case 2: System.out.println("What is " + num1 + " times " + num2 + "?");
				break;
		case 3: System.out.println("What is " + num1 + " minus " + num2 + "?");
				break;
		case 4: System.out.println("What is " + num1 + " divided by " + num2 + "?");
				break;
		// If the user chooses random operations, initialize a switch within a switch that asks user a random
		// question using random operations.
		case 5: switch(option)
				{
				case 1: System.out.println("What is " + num1 + " plus " + num2 + "?");
						break;
				case 2: System.out.println("What is " + num1 + " times " + num2 + "?");
						break;
				case 3: System.out.println("What is " + num1 + " minus " + num2 + "?");
						break;
				case 4: System.out.println("What is " + num1 + " divided by " + num2 + "?");
						break;
				}
		}
	}
	// This function creates a quiz using all the functions except for the main function.
	public static void quiz()
	{
		// Initialize instance variables and create a random number generator.
		int num1, num2, option, difficulty, type, counter = 0;
		int response = 1;
		int answer = 0;
		SecureRandom rand = new SecureRandom();
		// Loop through the program while the user chooses to do so.
		while(response == 1)
		{
			// Ask the user which arithmetic they would like to master, with 1 being addition, 2 multiplication,
			// 3 subtraction, 4 division, and 5 is random operations.
			System.out.println("Which arithmetic would you like to master?");
			// Call upon the readProblemType function to read the problem type.
			type = readProblemType();
			// Ask the user to enter a difficulty level based on the number of digits in the numbers.
			System.out.println("Please enter a difficulty level between 1 and 4: ");
			// Read the user's choice for the difficulty level.
			difficulty = readDifficulty();
			// Ask the user 10 different questions
			for(int i = 0; i < 10; i++)
			{
				// Generate two different numbers based on the difficulty.
				num1 = generateQuestionArgument(difficulty);
				num2 = generateQuestionArgument(difficulty);
				// Retrieve a random number between 1 and 4 that will be the option.
				option = rand.nextInt(4) + 1;
				// Ask the user a random question with their preferred operation.
				askQuestion(num1, num2, type, option);
				// Read the user's response to the question.
				int userInput = readResponse();
				// Generate an answer using the type that the user input.
				if(type == 1)
					answer = num1 + num2;
				else if(type == 2)
					answer = num1 * num2;
				else if(type == 3)
					answer = num1 - num2;
				else if(type == 4)
					answer = num1 / num2;
				else if(type == 5)
				{
					// Generate an answer using the option if the user chose type 5.
					if(option == 1)
						answer = num1 + num2;
					else if(option == 2)
						answer = num1 * num2;
					else if(option == 3)
						answer = num1 - num2;
					else if(option == 4)
						answer = num1 / num2;
					else if(option == 5)
						answer = solveRando(option, num1, num2);
				}
				//If the answer is correct, display a correct response and add one to the counter.	
				if(isAnswerCorrect(userInput, answer))
				{
					displayCorrectResponse();
					counter++;
				}
				// If the answer is wrong, display an incorrect response.
				else
				{
					displayIncorrectResponse();
				}
			}
			// Display the completion message that the user got using the counter as a parameter.
			displayCompletionMessage(counter);
			// Ask the user if they would like to try again.
			System.out.println("Would you like to try again? 1 for yes, 2 for no.");
			response = readResponse();
		}
	}
	// This function checks if the answer is correct by comparing the input with the answer and seeing if they are equal.
	public static boolean isAnswerCorrect(int input, int answer)
	{
		if(input == answer)
			return true;
		else
			return false;
	}
	// This function displays a completion message using the score the user got.
	public static void displayCompletionMessage(int score)
	{
		// If the score is less than 8, then tell the user that they need extra help. Else, congratulate them.
		if(score < 8)
			System.out.println("Please ask your teacher for extra help.\n");
		else
			System.out.println("Congratulations, you are ready to go to the next level!\n");
	}
	// This function reads the difficulty of the problem.
	public static int readDifficulty()
	{
		int level = readResponse();
		return level;
	}
	// This function generates a question using the level the user has input. 
	public static int generateQuestionArgument(int level)
	{
		SecureRandom rand = new SecureRandom();
		int num = 0;
		// Utilize a switch to generate a random number between the chosen level's number of digits.
		// ex: 1 is 0-9, 2 is 0-99, 3 is 0-999, and so on.
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
		return num;
	}
	// This function reads the problem type.
	public static int readProblemType()
	{
		int type = readResponse();
		return type;
	}
	// This function solves a random problem if the user has chosen option 5.
	public static int solveRando(int option, int num1, int num2)
	{
		int answer = 0;
		// If the option is 1, then it is addition. 2: subtraction, 3: multiplication, and 4: division.
		if(option == 1)
			answer = num1 + num2;
		else if(option == 2)
			answer = num1 * num2;
		else if(option == 3)
			answer = num1 - num2;
		else if(option == 4)
			answer = num1 / num2;
		return answer;
	}

	public static void main(String[] args) {
		quiz();
	}

}