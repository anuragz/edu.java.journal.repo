package edu.java.journal.basic.methodreference;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		String inStr = "Lambdas add power to java";
		String outStr = stringOps(MyStringOps::strReverse, inStr);
		System.out.println(inStr);
		System.out.println(outStr);
	}

	static String stringOps(StringFunc sf, String s) {
		return sf.func(s);
	}

}

class MyStringOps {

	static String strReverse(String str) {
		String result = "";
		int i;
		for (i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	}

}

interface StringFunc {

	String func(String s);

}
