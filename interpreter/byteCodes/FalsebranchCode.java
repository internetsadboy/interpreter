package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// FALSEBRANCH <label>
// pop the top of the stack
// if false(0) -> branch to <label>
// else execute next bytecode
public class FalsebranchCode extends ByteCode {
	private String label;
	public FalsebranchCode() {}
	public void init(Vector<String> args) {
		label = args.get(1);
	}
	public void exec(VirtualMachine vm) {
		int topOfStack = vm.popRunStack();
		if(topOfStack == 0) {
			// goto label ?
		} 
		// else execute next bytecode
	}
	public void print() {
		System.out.println("FalsebranchCode");
	}	
}