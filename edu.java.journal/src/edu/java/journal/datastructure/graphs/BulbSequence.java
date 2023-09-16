package edu.java.journal.datastructure.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BulbSequence {

	public static int getOpsCount(String s1, String s2) {
		int opsCounter = 0;
		char[] seq1 = s1.toCharArray();
		char[] seq2 = s2.toCharArray();
		char[] result = new char[seq2.length];
		ArrayList<Character> temp1 = new ArrayList<>();
		ArrayList<Character> temp2 = new ArrayList<>();

		System.out.println("-------------------");
		System.out.println("seq1: " + Arrays.toString(seq1));
		System.out.println("seq2: " + Arrays.toString(seq2));

		if (s1.contains(s2) || s2.contains(s1)) {
			return opsCounter + (Math.abs(seq2.length - seq1.length));
		}
		for (int i = 0; i < seq2.length; i++) {
			if (seq2[i] == seq1[i]) {
				result[i] = seq2[i];
			} else {
				temp1.add(seq1[i]);
				temp2.add(seq2[i]);
				result[i] = '.';
			}
		}

		// replace operations
		int twinOps = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i] == '.') {
				// check the element in seq2
				char c = seq2[i];

				if (temp1.contains(c)) {
					result[i] = c;
					temp1.remove(temp1.indexOf(c));
					twinOps++;
				} else {
					if (temp2.contains(c)) {
						result[i] = c;
						temp2.remove(temp2.indexOf(c));
						opsCounter++;// add operation
					}
				}
			}
			System.out.println("result: " + Arrays.toString(result));
		}

		opsCounter = opsCounter + (twinOps / 2);
		System.out.println("temp1:" + temp1);
		System.out.println("temp2:" + temp2);
		// System.out.println("-------------------");

		// Add removed elements steps
		opsCounter = opsCounter + (temp1.size());
		return opsCounter;

	}

	// -----------------------------------
	@Test
	public void test0() {
		int expected = 1;
		String s1 = "asdfgh";
		String s2 = "sdfgh";
		assertEquals(expected, getOpsCount(s1, s2));
	}

	@Test
	public void test1() {
		int expected = 2;
		String s1 = "asdfghz";
		String s2 = "sdfgh";
		assertEquals(expected, getOpsCount(s1, s2));
	}

	@Test
	public void test2() {
		int expected = 1;
		String s1 = "asdfgh";
		String s2 = "sadfgh";
		assertEquals(expected, getOpsCount(s1, s2));
	}

	@Test
	public void test3() {
		int expected = 2;
		String s1 = "a";// remove a +1 & add s +1 = 2
		String s2 = "s";
		assertEquals(expected, getOpsCount(s1, s2));
	}

	@Test
	public void test4() {
		int expected = 6;
		String s1 = "aaa";// remove a +1 & add s +1 = 2
		String s2 = "sss";
		assertEquals(expected, getOpsCount(s1, s2));
	}

	@Test
	public void test5() {
		int expected = 2;
		String s1 = "asdfghz";
		String s2 = "aszdfgh";
		assertEquals(expected, getOpsCount(s1, s2));
	}

}
