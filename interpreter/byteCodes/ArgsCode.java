package interpreter.byteCodes;
import interpreter.*;

// used prior to calling a fxn
// ARGS n (n == numArgs)
// instructs the interpreter to set up a new fram (offset n)
public class ArgsCode extends ByteCode {

	private String numArgs = "";

	public ArgsCode() {}
	
	public void print() {
		System.out.println("ArgsCode");
	}	

	// error if args.size() > 1
	public void init(Vector<String> args) {
		numArgs = args.get(1);
	}
	
	// push ne
	public void exec(VirtualMachine vm) {
		vm.newFrameAtRunStack(numArgs);
	}

}