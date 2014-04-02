package interpreter.byteCodes;
import interpreter.*;

// GOTO <label>
public class GotoCode extends ByteCode {
	private String gotoArg;
	public GotoCode() {}
	public void print() {
		System.out.println("GotoCode");
	}	
	public void init(Vector<String> args) {
		gotoArg = args.get(1);
	}
	public void exec(VirtualMachine vm) {
		// do stuff
	}
	
}