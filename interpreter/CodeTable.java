package interpreter;

import java.util.*;
import java.io.*;

// used by ByteCodeLoader
// contains HashMap (bytecodes, bytecode class names)
// BCL will load the bytecodes from the bytecode src file into the VM
// then CodeTable will be used to create bytecode instances
// e.g. HALT -> CodeTable.get("HALT") -> HaltCode -> create instance -> store in Program obj
public class CodeTable extends Object {

	private static Map<String, String> bytecodesHash = new HashMap<String, String>();

	public CodeTable() {
		init();
	}

	// initialize HashMap values (bytecode, bytecode class)
	public static void init() {
		// build file path
		String cwd = System.getProperty("user.dir"); 
		String fileName = "bytecodes.txt";
		String filePath = cwd+"/"+fileName;
		BufferedReader in;
		try {
			// read file
			in = new BufferedReader(new FileReader(filePath));
			String line = null;
			// iterate through each line (each bytecode)
			while((line = in.readLine()) != null) {
				// add bytecode and bytecode class name to HashMap
				bytecodesHash.put(line.toUpperCase(), line+"Code");
			}	
			// catch exceptions
		} catch(FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
		  System.err.println("Caught IOException: " + e.getMessage());
		}
	}

	// return corresponding bytecode class (keeps the hash encapsulated)
	public static String get(String bytecode) {
		return bytecodesHash.get(bytecode);
	}

	// for testing, logs all key-value pairs to the console
	public void logHashMap() {
		Object[] vals = (bytecodesHash.entrySet()).toArray();
		for(int i = 0; i < vals.length; i++) {
			System.out.println(vals[i]);	
		}
	}

}