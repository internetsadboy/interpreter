package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// STORE n <id>
// STORE 2 i
// pop the top of the stack
// store value into offset n from the start of the current frame
public class StoreCode extends ByteCode {
	private int offset;
	private String id;
	private Vector<String> srcLine;
	public StoreCode() {}
	public void init(Vector<String> args) {
		offset = Integer.parseInt(args.get(1));
		if(args.size() == 3) {
			id = args.get(2);
		}
		srcLine = args;
	}	
	public void exec(VirtualMachine vm) {
		int topItem = vm.popRunStack();
		int currentFrameStartIndex = vm.getCurrentFrameRunStack();
		// line 8
		if(vm.isDumping()) {
			for(int i = 0; i < srcLine.size(); i++) {
				System.out.print(srcLine.get(i)+" ");
			}
			if(srcLine.size() == 3) {
				System.out.println("  "+id+" = "+topItem);
			} else {
				System.out.println();
			}
			vm.dumpRunStack();
		}
	}
	public void print() {
		System.out.println("StoreCode");
	}	
}