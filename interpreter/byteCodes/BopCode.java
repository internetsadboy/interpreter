package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// pop top 2 levels of the stack 
// BOP operation e.g. BOP + 
// | -> ||
// & -> &&
public class BopCode extends ByteCode {

	// x second level item
	// y top level item
	private String operation;
	private int x;   
	private int y;    
	private int result;

	public BopCode() {}

	public void print() {
		System.out.println("BopCode");
	}	
	
	// throw err if args.size() > 1
	public void init(Vector<String> args) {
		operation = args.get(1);
	}
	
	public void exec(VirtualMachine vm) {
		x = vm.popRunStack();
		y = vm.popRunStack();
		switch(operation) {
			case "+": result = x + y;
								vm.pushRunStack(result);
								break;
			case "-": result = x - y;
								vm.pushRunStack(result);
								break;
			case "/": result = x / y;
								vm.pushRunStack(result);	
								break;
			case "*": result = x * y;
								vm.pushRunStack(result);
								break;
			case "==":if(x == y) vm.pushRunStack(1);
								else vm.pushRunStack(0); 
								break;
			case "!=":if(x != y) vm.pushRunStack(1);
								else vm.pushRunStack(0);	
								break;
			case "<=":if(x <= y) vm.pushRunStack(1);
								else vm.pushRunStack(0);		
								break;
			case ">": if(x > y) vm.pushRunStack(1);
								else vm.pushRunStack(0);									
								break;
			case ">=":if(x >= y) vm.pushRunStack(1);
								else vm.pushRunStack(0);
								break;
			case "<": if(x < y) vm.pushRunStack(1);
								else vm.pushRunStack(0);
								break;
			case "|": if(x == (int)x || y == (int)y) vm.pushRunStack(1);
								else vm.pushRunStack(0);
								break;
			case "&": if(x == (int)x && y == (int)y) vm.pushRunStack(1);
								else vm.pushRunStack(0);
								break;
		}	
	}
	
}