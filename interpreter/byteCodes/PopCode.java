package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// POP n
// pop top 'n' levels of runtime stack
// param {int} n, 1 arg 
public class PopCode extends ByteCode {
	private int popArg;
	public PopCode() {}
	public void init(Vector<String> args) {
		popArg = Integer.parseInt(args.get(1));;
	}
	public void exec(VirtualMachine vm) {
		for(int i = 0; i < popArg; i++) {
			vm.popRunStack();
		}
	}
	public void print() {
		System.out.println("PopCode");
	}	
}