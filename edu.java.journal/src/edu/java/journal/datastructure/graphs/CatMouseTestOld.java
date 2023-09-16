package edu.java.journal.datastructure.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CatMouseTestOld {

	@Test
	public void test1() {
		int mouseDistance[] = { 1, 1, 1, 1 };
		int tomDistance = 2;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test10() {
		int mouseDistance[] = { 100001, 100001, 100001, 100001 };
		int tomDistance = 100002;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test11() {
		int mouseDistance[] = { 100000, 100000, 100000, 100000 };
		int tomDistance = 100001;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test12() {
		int mouseDistance[] = { 2, 2, 2, 2, 2 };
		int tomDistance = 9;
		assertEquals(4, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test13() {
		int mouseDistance[] = { 5, 3, 3, 11, 13, 15, 17, 19, 21, 23, 25 };
		int tomDistance = 26;
		assertEquals(4, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test2() {
		int mouseDistance[] = { 1, 2, 3, 4 };
		int tomDistance = 6;
		assertEquals(2, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test3() {
		int mouseDistance[] = { 1 };
		int tomDistance = 2;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test4() {
		int mouseDistance[] = { 1, 1, 1, 1 };
		int tomDistance = 4;
		assertEquals(3, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test5() {
		int mouseDistance[] = { 7, 5, 3, 11 };
		int tomDistance = 12;
		assertEquals(2, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test6() {
		int mouseDistance[] = { 5, 3, 3, 11, 5, 17, 5, 3, 3, 11, 5, 17, 5, 3, 3,
				11, 5, 17, 5, 3, 3, 11, 5, 17, 5, 3, 3, 11, 5, 17, 5, 3, 3, 11,
				5, 17 };
		int tomDistance = 30;
		assertEquals(9, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test7() {
		int mouseDistance[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3,
				4, 4, 4, 5, 5, 6, 7, 8, 8 };
		int tomDistance = 2;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test8() {
		int mouseDistance[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2 };
		int tomDistance = 3;
		assertEquals(2, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test9() {
		int mouseDistance[] = { 1, 1, 1, 1 };
		int tomDistance = 5;
		assertEquals(4, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

}
