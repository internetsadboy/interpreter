package interpreter.byteCodes;
import interpreter.*;

public class LoadCode extends ByteCode {
	public LoadCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {}
	public void print() {
		System.out.println("LoadCode");
	}	
}