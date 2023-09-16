package edu.java.journal.basic.lambda;

public class LambdaDemo2 {

	public static void main(String[] args) {
		StringFunc sf = (s) -> {
			return s.toUpperCase();
		};
		String text = stringOp(sf, "hello");
		System.out.println(text);

		sf = (s) -> {
			return String.join(",", "hello", s);
		};
		System.out.println(stringOp(sf, "world"));
	}

	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}

}

interface StringFunc {

	String func(String s);

}
