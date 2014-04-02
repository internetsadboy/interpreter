package interpreter.byteCodes;
import interpreter.*;

// 'halts' execution, 0 args
// non-error termination
public class HaltCode extends ByteCode {
	public HaltCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {
		System.exit(0); 
	}
	public void print() {
		System.out.println("HaltCode");
	}	
}