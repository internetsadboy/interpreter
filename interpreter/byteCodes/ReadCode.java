package interpreter.byteCodes;
import interpreter.*;

public class ReadCode extends ByteCode {
	public ReadCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {}
	public void print() {
		System.out.println("ReadCode");
	}	
}