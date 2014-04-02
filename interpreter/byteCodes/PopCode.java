package interpreter.byteCodes;
import interpreter.*;

// pop top 'n' levels of runtime stack
// param {int} n, 1 arg 
public class PopCode extends ByteCode {
	public PopCode() {}
	public void init(int n) {
		
	}
	public void exec(VirtualMachine vm) {}
	public void print() {
		System.out.println("PopCode");
	}	
}