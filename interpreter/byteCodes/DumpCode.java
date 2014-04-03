package interpreter.byteCodes;
import interpreter.*;
import java.util.*;

public class DumpCode extends ByteCode {
	private String dumpArg;
	public DumpCode() {}
	public void init(Vector<String> args) {
		dumpArg = args.get(1);
	}
	public void exec(VirtualMachine vm) {
		if(dumpArg.equals("ON")) {
			vm.setDumpingOn(true);
		} else {
			vm.setDumpingOn(false);
		}
	}

}