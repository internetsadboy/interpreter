package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

// STORE n <id>
// STORE 2 i
// pop the top of the stack
// store value into offset n from the start of the current frame
public class StoreCode extends ByteCode {
	private int offset;
	public StoreCode() {}
	public void init(Vector<String> args) {
		offset = Integer.parseInt(args.get(1));;
	}	
	public void exec(VirtualMachine vm) {
		int topItem = vm.popRunStack();
		int currentFrameStartIndex = vm.getCurrentFrameRunStack();
	}
	public void print() {
		System.out.println("StoreCode");
	}	
}