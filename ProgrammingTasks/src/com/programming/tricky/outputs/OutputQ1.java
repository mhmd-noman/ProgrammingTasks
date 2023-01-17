package com.programming.tricky.outputs;


public class OutputQ1 {
	@SuppressWarnings("finally")
	public static void method1() throws Exception {
		try{
			System.out.println("5");
			throw new MyException1();
		} catch (Exception e) {
			System.out.println("6");
			throw new MyException2();
		} finally {
			System.out.println("7");
			throw new Exception();
		}
	}

	@SuppressWarnings("finally")
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("1");
			method1();
			System.out.println("2");
		} catch (Exception e) {
			System.out.println("3");
			throw new MyException2();
		} finally {
			System.out.println("4");
			throw new MyException1();
		}
	}
}


class MyException1 extends Exception {
	private static final long serialVersionUID = 1L;
}
class MyException2 extends Exception {
	private static final long serialVersionUID = 1L; 
}
