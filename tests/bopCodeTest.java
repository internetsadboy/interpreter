import java.util.*;

public class bopCodeTest {

	// x is second level 
	// y is top level
	public static void main(String[] args) {

		int x = 3; 
		int y = 9;
		int result = 0;
		String[] ops = {"+","-","/","*","==","!=","<=",">",">=","<","|","&"};
		VM vm = new VM();

		for(int i = 0; i < ops.length; i++) {
			String operation = ops[i];
			switch(operation) {
				case "+": result = x + y;
									vm.pushRunStack(result);
									System.out.println(result);
									break;
				case "-": result = x - y;
									vm.pushRunStack(result);
									System.out.println(result);
									break;
				case "/": result = x / y;
									vm.pushRunStack(result);
									System.out.println(result);
									break;
				case "*": result = x * y;
									vm.pushRunStack(result);
									System.out.println(result);
									break;
				case "==":if(x == y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
								  System.out.println(x==y);
								  break;
				case "!=":if(x != y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x != y);
								  break;
				case "<=":if(x <= y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x <= y);
								  break;
				case ">": if(x > y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x > y);
								  break;
				case ">=":if(x >= y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x >= y);
								  break;
				case "<": if(x < y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x < y);
								  break;
				case "|": if(x == (int)x || y == (int)y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x == (int)x || y == (int)y);
								  break;
				case "&": if(x == (int)x && y == (int)y) vm.pushRunStack(1);
									else vm.pushRunStack(0);
									System.out.println(x == (int)x && y == (int)y);
								  break;
			}

		}
		
  }
}

class VM {

	private Stack<Integer> stack = new Stack<Integer>();

	public VM() {}

	public void pushRunStack(int i) {
		stack.push(i);
	}

	public void print() {
		System.out.println(stack.toString());
	}
}