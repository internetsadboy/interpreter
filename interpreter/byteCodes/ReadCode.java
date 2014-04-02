package interpreter.byteCodes;
import interpreter.*;
import java.util.*;


// READ
// ask the user to input an integer
// push that value on top of the stack
public class ReadCode extends ByteCode {
	public ReadCode() {}
	public void init(Vector<String> args) {}
	public void exec(VirtualMachine vm) {
		Scanner input = new Scanner(System.in);
		System.out.println("**** HELLO USER ****");
		int userInput;
		do {
			System.out.print("Enter an integer user: ");
			userInput = input.nextInt();
		} while(userInput != (int)userInput);
		vm.pushRunStack(userInput);
	}
	public void print() {
		System.out.println("ReadCode");
	}	
}