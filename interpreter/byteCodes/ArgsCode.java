package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// used prior to calling a fxn
// ARGS n (n == numArgs)
// instructs the interpreter to set up a new fram (offset n)
public class ArgsCode extends ByteCode {

	private int numArgs;
	private Vector<String> srcLine;

	public ArgsCode() {}
	
	public void print() {
		System.out.println("ArgsCode");
	}	

	// error if args.size() > 1
	public void init(Vector<String> args) {
		numArgs = Integer.parseInt(args.get(1));
		srcLine = args;
	}
	
	// push 
	public void exec(VirtualMachine vm) {
		vm.newFrameAtRunStack(numArgs);
		if(vm.isDumping()) {
			// print out args
			for(int i = 0; i < srcLine.size(); i++) {
				System.out.print(srcLine.get(i)+" ");
			}
		}
		
	}

}