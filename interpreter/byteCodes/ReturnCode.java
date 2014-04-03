package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// RETURN <funcname>
// RETURN someInt (resolved numerical address)
// return from the current function
public class ReturnCode extends ByteCode {
	private String id;
	private Vector<String> srcLine;
	public ReturnCode() {}
	public void init(Vector<String> args) {
		if(args.size() == 2) {
			id = args.get(1);
		}
		srcLine = args;
	}
	public void exec(VirtualMachine vm) {
		// dump all values w/in fxn's frame ?
		if(vm.isDumping()) {
			for(int i = 0; i < srcLine.size(); i++) {
				System.out.print(srcLine.get(i)+" ");
			}
			if(srcLine.size() == 2) {
				int topItem = vm.peekRunStack();
				System.out.println("  exit "+id+": "+topItem);
			} else {
				System.out.println();
			}
			vm.dumpRunStack();
		}
	}
	public void print() {
		System.out.println("ReturnCode");
	}	
}