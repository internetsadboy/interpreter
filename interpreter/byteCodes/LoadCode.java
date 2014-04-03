package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// LOAD n <id>
// LOAD 1, w/ stack [1,2,3] -> [1,2,3,2]
public class LoadCode extends ByteCode {
	private int loadArg1;
	private String loadArg2;
	private Vector<String> srcLine;
	public LoadCode() {}
	public void init(Vector<String> args) {
		loadArg1 = Integer.parseInt(args.get(1));
		if(args.size() == 3) {
			loadArg2 = args.get(2);
		}
		srcLine = args;
	}
	public void exec(VirtualMachine vm) {
		// manipulate
		vm.loadRunStack(loadArg1);
		// dump if ON
		if(vm.isDumping()) {
			for(int i = 0; i < srcLine.size(); i++) {
				System.out.print(srcLine.get(i)+" ");
			}
			if(srcLine.size() == 3) {
				System.out.println("  <load "+loadArg2+">");
			} else {
				System.out.println();
			}
			vm.dumpRunStack();
		}
	}
	public void print() {
		System.out.println("LoadCode");
	}	
}