package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// RETURN <funcname>
// RETURN someInt (resolved numerical address)
// return from the current function
public class ReturnCode extends ByteCode {
	private int currentFunction;
	public ReturnCode() {}
	public void init(Vector<String> args) {
		currentFunction = Integer.parseInt(args.get(1));;
	}
	public void exec(VirtualMachine vm) {
		// dump all values w/in fxn's frame ?
	}
	public void print() {
		System.out.println("ReturnCode");
	}	
}