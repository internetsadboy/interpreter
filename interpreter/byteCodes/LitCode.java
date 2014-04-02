package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

public class LitCode extends ByteCode {
	private int litArg1;
	private int litArg2;
	private boolean twoArgs = false;
	public LitCode() {}
	public void init(Vector<String> args) {
		if(args.size() == 2) {
			twoArgs = true;
			litArg1 = Integer.parseInt(args.get(1));;
		} else {
			litArg1 = Integer.parseInt(args.get(1));;
			litArg2 = Integer.parseInt(args.get(2));;
		}
	}
	public void exec(VirtualMachine vm) {
		if(twoArgs == true) {
			vm.pushRunStack(litArg1); // LIT 5
		} else {
			vm.pushRunStack(litArg1); // LIT 0 i
		}

	}
	public void print() {
		System.out.println("LitCode");
	}	
}