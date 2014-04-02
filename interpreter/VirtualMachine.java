package interpreter;

import interpreter.byteCodes.*;
import java.util.*;


// vm owns its stacks
// don't break encapsulation
// create vm methods that perform operations on the stacks
public class VirtualMachine {
	
	private int pc;
	private RunTimeStack runStack;
	private Stack<Integer> returnAddrs; // corresponds to framePointers in rts
	private boolean isRunning;
	private Program program;

	public VirtualMachine(Program prog) {
		program = prog;
	}
	
	public void executeProgram() {
		pc = 0;
		runStack = new RunTimeStack();
		returnAddrs = new Stack();
		isRunning = true;
		while(isRunning) {
			ByteCode code = program.getCode(pc);
			code.exec(this);
			pc++;
		}
	}

	// pop and return item from the rts
	public int popRunStack() {
		return runStack.pop();
	}

	// push and return new item onto rts
	public int pushRunStack(int item) {
		return runStack.push(item);
	}

	// get and return top item from rts
	public int peekRunStack() {
		return runStack.get(0);
	}

	// start new frame, offset indicates n positions from the top of the rts
	// ref runStack.framePointers.push(offset) 
	// new frame == new fxn => push pc onto returnAdd
	public void newFrameAtRunStack(int offset) {
		runStack.newFrameAt(offset);
		returnAddrs.push(pc);
	}
}