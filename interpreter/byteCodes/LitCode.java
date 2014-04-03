package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

public class LitCode extends ByteCode {
	private int litArg1;
	private String litArg2;
	private boolean twoArgs = false;
	private Vector<String> srcLine;
	public LitCode() {}
	public void init(Vector<String> args) {
		srcLine = args;
		if(args.size() == 2) {
			twoArgs = true;
			litArg1 = Integer.parseInt(args.get(1));;
		} else {
			litArg1 = Integer.parseInt(args.get(1));;
			litArg2 = args.get(2);
		}
	}
	public void exec(VirtualMachine vm) {
		// manipulations
		if(twoArgs == true) {
			vm.pushRunStack(litArg1); // LIT 5
		} else {
			vm.pushRunStack(litArg1); // LIT 0 i
		}
		// dump if ON
		if(vm.isDumping()) {
			for(int i = 0; i < srcLine.size(); i++) {
				System.out.print(srcLine.get(i)+" ");
			}
			if(srcLine.size() == 3) {
				System.out.println("   int "+litArg2);
			} else {
				System.out.println();
			}
			vm.dumpRunStack();
		}

	}
	public void print() {
		System.out.println("LitCode");
	}	
}