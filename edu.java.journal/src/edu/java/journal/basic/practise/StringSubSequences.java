package edu.java.journal.basic.practise;

public class StringSubSequences {

	public static void main(String[] args) {
		String input = "abc";
		System.out.println("Input: " + input + "\nSubsequences: \n");
		System.out.println(subSequences(input, input.length()));
	}

	private static String subSequences(String input, int n) {
		if (input.length() == 0) {
			return "";
		}

		char first = input.charAt(0);
		String rest = input.substring(n - (n - 1), n);

		System.out.println(first + "," + rest);

		subSequences(rest, rest.length());
		return rest;
	}

}
