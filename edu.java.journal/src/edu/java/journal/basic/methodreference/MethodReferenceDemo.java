package edu.java.journal.basic.methodreference;

interface StringFunc{
	String func(String s);
}

class MyStringOps{
	static String strReverse(String str) {
		String result = "";
		int i;
		for(i=str.length()-1;i>=0;i--) {
			result += str.charAt(i);
		}
		return result;
	}
}
public class MethodReferenceDemo {

	static String stringOps(StringFunc sf, String s) {
		return sf.func(s);
	}
	public static void main(String[] args) {
		String inStr = "Lambdas add power to java";
		String outStr = stringOps(MyStringOps::strReverse, inStr);
		System.out.println(inStr);
		System.out.println(outStr);
	}
}
