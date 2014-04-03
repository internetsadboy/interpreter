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
	private boolean isDumping;

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

	public void setDumpingOn(boolean yesOrNo) {
		isDumping = yesOrNo;
		System.out.print("DUMP ");
		System.out.println(isDumping);
	}

	public boolean isDumping() {
		return isDumping;
	}

	public void dumpRunStack() {
		runStack.dump();
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
		return runStack.peek();
	}

	// used to push literals onto the stack e.g. LIT 5
	public Integer pushRunStack(Integer i) {
		int castedInteger = (int)i;
	  return runStack.push(castedInteger);
	}

	// get item from index n 
	// push item from index n onto the top of the stack
	// loads vars onto stack
	public int loadRunStack(int offset) {
		return runStack.load(offset);
	}

	// start new frame, offset indicates n positions from the top of the rts
	// ref runStack.framePointers.push(offset) 
	// new frame == new fxn => push pc onto returnAdd
	public void newFrameAtRunStack(int offset) {
		runStack.newFrameAt(offset);
		returnAddrs.push(pc);
	}

	public int getCurrentFrameRunStack() {
		return runStack.getCurrentFrameIndex();
	}
}