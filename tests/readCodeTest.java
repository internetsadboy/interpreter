import java.util.*;

public class readCodeTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("**** HELLO USER ****");
		int userInput;
		do {
			System.out.print("Enter an integer user: ");
			userInput = input.nextInt();
		} while(userInput != (int)userInput);
	}
}