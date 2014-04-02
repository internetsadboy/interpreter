package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// CALL <function> 
// transfer control to the indicated function
public class CallCode extends ByteCode {
	private String callArg;
	public CallCode() {}
	public void print() {
		System.out.println("CallCode");
	}	
	public void init(Vector<String> args) {
		callArg = args.get(1);
	}
	public void exec(VirtualMachine vm) {
		// do stuff
	}	
}