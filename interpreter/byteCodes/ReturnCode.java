package interpreter.byteCodes;
import interpreter.*;

public class ReturnCode extends ByteCode {
	public ReturnCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {}
	public void print() {
		System.out.println("ReturnCode");
	}	
}