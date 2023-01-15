package com.programming.tasks;

public class CodeExecutionWithMainMethod {
	static {
		System.out.print("This is static block, which can be executed before main method. \n"
				+ "And Static block in Java is a group of statements that gets executed only once when the class is loaded into the memory by Java ClassLoader,\n"
				+ "It is also known as a static initialization block. Static initialization block is going directly into the stack memory.  \n"
				+ "We can execute a java program without a main method (works until Java 1.6 version). \n"
				+ "Java 7 and newer versions don’t allow this because JVM checks the presence of the main method before initializing the class.");
	}
	
	public static void main(String[] args) {
	}

}
