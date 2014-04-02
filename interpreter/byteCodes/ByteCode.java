package interpreter.byteCodes;
import interpreter.*;
import java.util.*;


public abstract class ByteCode extends Object {
	protected StringTokenizer args;
	public ByteCode() {}
	public void print() {}
	public void init(Vector<String> args) {}
	public void exec(VirtualMachine vm) {
		
	}
}