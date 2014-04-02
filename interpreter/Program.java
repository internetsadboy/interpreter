package interpreter;

import interpreter.byteCodes.*;
import java.util.*;
import java.io.*;

public class Program {
	
	private Vector<ByteCode> byteCodeInstances = new Vector<ByteCode>();	
	private Vector<Vector<String>> byteCodeFile = new Vector<Vector<String>>();

	public Program() {}

	// identify 1st token (bytecode)
	// see if it's a bc that needs resolving
	// if needs resolving -> iterate through the rest of list
	// use find matching location 
	// replace the address token w/ matching # location
	public void resolveAddresses() {
	  for(int i = 0; i < byteCodeFile.size(); i++) {
			String byteCode = byteCodeFile.get(i).get(0);
			if(byteCode.equals("FALSEBRANCH") || byteCode.equals("GOTO") || byteCode.equals("RETURN") || byteCode.equals("CALL")) {
				int address = 0;
				String byteCodeArg = byteCodeFile.get(i).get(1);
				for(int j = 0; j < byteCodeFile.size(); j++) {
					String label = byteCodeFile.get(j).get(0);
					if(label.equals("LABEL")) {
						String labelArg = byteCodeFile.get(j).get(1);
						if(labelArg.equals(byteCodeArg)) {
							address = j;
							break;	
						}	
					}
				}
				// if address doesn't change then it wasn't available
				// remove arg
				// add 'address'
				if(address != 0) {
					byteCodeFile.get(i).remove(1);
				  byteCodeFile.get(i).add(Integer.toString(address));
				}
			}
		}
	}

	// returns a bytecode to be executed in the vm
	public ByteCode getCode(int pc) {
		return byteCodeInstances.get(pc);
	}

	public void setByteCodeInstances(Vector<ByteCode> newByteCodes) {
		for(int i = 0; i < newByteCodes.size(); i++) {
			byteCodeInstances.add(newByteCodes.get(i));
		}
	}
	public void printByteCodeInstances() {
		for(int i = 0; i < byteCodeInstances.size(); i++) {
			byteCodeInstances.get(i).print();
		}
	}
	
	public void setByteCodeFile(Vector<Vector<String>> srcFile) {
		for(int i = 0; i < srcFile.size(); i++) {
			byteCodeFile.add(srcFile.get(i));		
		}
	}

	public void printByteCodeFile() {
		for(int i = 0; i < byteCodeFile.size(); i++) {
			for(int j = 0; j < byteCodeFile.get(i).size(); j++) {
				System.out.print(byteCodeFile.get(i).get(j)+" ");	
			}
			System.out.println();
		}
	}

}