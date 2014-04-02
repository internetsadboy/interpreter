package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// LOAD n <id>
// LOAD 1, w/ stack [1,2,3] -> [1,2,3,2]
public class LoadCode extends ByteCode {
	private int loadArg;
	public LoadCode() {}
	public void init(Vector<String> args) {
		loadArg = Integer.parseInt(args.get(1));
	}
	public void exec(VirtualMachine vm) {
		vm.loadRunStack(loadArg);
	}
	public void print() {
		System.out.println("LoadCode");
	}	
}