
package com.billTracker.testutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// boiler-plate code

public class TestUtils {

	public static File businessTestFile;
	public static File DbConnectionTest;
	public static File exceptionTestFile;
	static {
		businessTestFile = new File("./output_revised.txt");
		businessTestFile.delete();

		DbConnectionTest = new File("./output_dbconnections_revised.txt");
		DbConnectionTest.delete();

		exceptionTestFile = new File("./output_exception_revised.txt");
		exceptionTestFile.delete();
	}

	public static void yakshaAssert(String testName, Object result, File file) throws IOException {

		System.out.println("\n" + testName + "=" + result);
		FileWriter writer = new FileWriter(file, true);
		writer.append("\n" + testName + "=" + result);
		writer.flush();
		writer.close();
	}

	public static String currentTest() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

}