package interpreter;

import java.util.*;

public class RunTimeStack {
	
	private Stack<Integer> framePointers = new Stack<Integer>(); // changed from Stack<Integer>
	private Vector<Integer> runStack = new Vector<Integer>();

	public RunTimeStack() {
		framePointers.push(0);
	}

	// dump the rts info for debugging
	public void dump() {
		// print out data in the rts
	}

	// returns the top item on the rts
	public int peek() {
		return runStack.get(0);
	}

	// remove and return the top item on the rts
	public int pop() {
		return runStack.remove(0);
	}

	// add element to the top of the stack
	public int push(int i) {
		runStack.add(0, i);
		return i;
	}

	// start new frame, offset indicates n positions from the top of the rts
	public void newFrameAt(int offset) {
		framePointers.push(offset);
	}

	// pop top frame when returning from a fxn
	// save the return val
	// pop the top frame
	// push the saved return val on the stack
	public void popFrame() {
		int returnValue = pop();
		framePointers.pop();
		push(returnValue);
	}

	// get size of the frame
	// locate the startIndex of the most current frame
	// return its value
	public int getCurrentFrameIndex() {
		int frameSize = framePointers.size();
		return framePointers.get(frameSize-1);
	}

	// stores variables
	public int store(int offset) {
		return 0;
	}

	// loads vars onto stack
	public int load(int offset) {
		int item = runStack.get(offset);
		push(item);
		return item;
	}

	// used to push literals onto the stack e.g. LIT 5
	public Integer push(Integer i) {
		return push((int)i);
	}

	// testing
	public static void main(String[] args) {
		RunTimeStack rts = new RunTimeStack();
		for(int i = 0; i < 6; i++) {
			rts.push(i);
		}
		rts.pop();
		rts.peek();
		rts.newFrameAt(3);
		rts.newFrameAt(6);
		rts.popFrame();
		System.out.println(rts.framePointers.toString());
		System.out.println(rts.runStack.toString());

	}
}