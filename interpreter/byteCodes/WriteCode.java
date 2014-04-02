package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

public class WriteCode extends ByteCode {
	public WriteCode() {}
	public void init(Vector<String> args) {}
	public void exec(VirtualMachine vm) {
		
	}
	public void print() {
		System.out.println("WriteCode");
	}	
}