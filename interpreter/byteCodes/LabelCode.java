package interpreter.byteCodes;
import interpreter.*;

// LABEL <label>
public class LabelCode extends ByteCode {
	private String labelArg;
	public LabelCode() {}
	public void init(Vector<String> args) {
		labelArg = args.get(1);
	}
	public void exec(VirtualMachine vm) {

	}
	public void print() {
		System.out.println("LabelCode");
	}	
}