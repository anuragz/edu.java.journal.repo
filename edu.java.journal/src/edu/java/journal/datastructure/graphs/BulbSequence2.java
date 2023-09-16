package edu.java.journal.datastructure.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BulbSequence2 {

	public static int getOpsCount(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return Math.abs(s1.length() - s2.length());
		}
		int opsCount = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				opsCount++;
			}
		}
		return opsCount / 2;
	}

	public static int getOpsCount2(String s1, String s2) {
		// find out occurrence of a colored bulb and add it to a map all the
		// occurrence should be multiple of 2
		// bulb in first chain should be same as in second chain
		// create two maps with positions of each bulb color and compare them
		// and for the changes count as operation
		// position map s1 & s2
		// if there are different number of positions of a color-bulb than we
		// need to either add or remove
		// if position count is same than they can be interchanged
		// to interchange the other color bulb should be present
		HashMap<Character, List<Integer>> S1positions = getPositionMap(s1);
		System.out.println(S1positions);
		HashMap<Character, List<Integer>> S2positions = getPositionMap(s2);
		System.out.println(S2positions);

		// get all the unique colored bulbs color
		HashSet<Character> charSet = new HashSet<>();
		for (Character c : s1.toCharArray()) {
			charSet.add(c);
		}
		for (Character c : s2.toCharArray()) {
			charSet.add(c);
		}

		int opsCounter = 0;
		for (Character c : charSet) {
			List<Integer> charPositionsS1 = S1positions.get(c);
			List<Integer> charPositionsS2 = S2positions.get(c);

			Collections.sort(charPositionsS1);
			Collections.sort(charPositionsS2);

			int charPositionsS1Size = charPositionsS1.size();
			int charPositionsS2Size = charPositionsS2.size();

			int maxCounts = 0;
			if (charPositionsS1Size > charPositionsS2Size) {
				maxCounts = charPositionsS1Size;
			} else {
				maxCounts = charPositionsS2Size;
			}

			for (int i = 0; i < maxCounts; i++) {

			}
		}

		return 0;
	}

	public static int getOpsCount3(String s1, String s2) {
		ArrayList<Character> list1 = new ArrayList<>();
		for (Character c : s1.toCharArray()) {
			list1.add(c);
		}
		ArrayList<Character> list2 = new ArrayList<>();
		for (Character c : s2.toCharArray()) {
			list2.add(c);
		}
		int opsCount = 0;
		int i = 0;
		operations(list1, list2, opsCount, i);

		return opsCount;
	}

	public static int getOpsCount5(String s1, String s2) {
		ArrayList<Character> list1 = new ArrayList<>();
		for (Character c : s1.toCharArray()) {
			list1.add(c);
		}
		ArrayList<Character> list2 = new ArrayList<>();
		for (Character c : s2.toCharArray()) {
			list2.add(c);
		}
		int opsCount = 0;

		return opsCount;
	}

	private static HashMap<Character, List<Integer>> getPositionMap(String s1) {
		HashMap<Character, List<Integer>> S1positions = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			if (S1positions.containsKey(s1.charAt(i))) {
				S1positions.get(s1.charAt(i)).add(i);
			} else {
				List<Integer> positions = new ArrayList<>();
				positions.add(i);
				S1positions.put(s1.charAt(i), positions);
			}
		}
		return S1positions;
	}

	// --------------------------------

	private static int operations(List<Character> list1, List<Character> list2,
			int opsCount, int i) {
		int list1IncrementIndex = 1;
		int list2IncrementIndex = 1;

		if (list1.equals(list2)) {
			return opsCount;
		}

		// shorter sequence cases
		if ((i > list1.size()) && (i < list2.size())) {
			list1.add(list2.get(i));
			list1IncrementIndex++;
			opsCount++;
		} else if ((i > list2.size()) && (i < list1.size())) {
			list2.add(list1.get(i));
			list2IncrementIndex++;
			opsCount++;
		}

		if (list1.size() == i) {
			return opsCount;
		}

		// same element case
		if (list1.get(i).equals(list2.get(i))) {
			// nothing to do
		} else {
			// exchange
			Character c = list1.get(i);
			List<Character> subList = list2.subList(list2IncrementIndex,
					list2.size());
			if (subList.contains(c)) {
				int indextoswap = subList.indexOf(c);
				Character swapc = subList.get(i);
				list2.set(i, c);
				list2.set(indextoswap, swapc);
				opsCount++;
			} else {
				list2.add(i, c);
				opsCount++;
				list2IncrementIndex++;
			}
		}
		i++;
		// operations(list1.subList(list1IncrementIndex, list1.size()),
		// list2.subList(list2IncrementIndex, list2.size()),opsCount,i);
		operations(list1, list2, opsCount, i);

		return opsCount;
	}

	// -----------------------------------
	@Test
	public void test1() {
		int expected = 1;
		String s1 = "asdfgh";
		String s2 = "sdfgh";
		assertEquals(expected, getOpsCount2(s1, s2));
	}

	@Test
	public void test2() {
		int expected = 1;
		String s1 = "asdfgh";
		String s2 = "sadfgh";
		assertEquals(expected, getOpsCount2(s1, s2));
	}

	@Test
	public void test3() {
		int expected = 2;
		String s1 = "a";// add s in end - 1
		String s2 = "s";// add a in start - 2
		assertEquals(expected, getOpsCount2(s1, s2));
	}

	@Test
	public void test4() {
		int expected = 6;
		String s1 = "aaa";// add s in end - 1
		String s2 = "sss";// add a in start - 2
		assertEquals(expected, getOpsCount3(s1, s2));
	}

}
