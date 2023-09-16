package edu.java.journal.datastructure.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CatMouseTest {

	@Test
	public void test() {
		int mouseDistance[] = { 2, 3, 1 };
		int tomDistance = 4;
		assertEquals(2, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test1() {
		int mouseDistance[] = { 1, 1, 1, 1 };
		int tomDistance = 2;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test3() {
		int mouseDistance[] = { 2, 3, 1, 4 };
		int tomDistance = 6;
		assertEquals(2, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test4() {
		int mouseDistance[] = { 3, 2 };
		int tomDistance = 3;
		assertEquals(1, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

	@Test
	public void test5() {
		int mouseDistance[] = { 8, 9, 6, 7, 8 };
		int tomDistance = 10;
		assertEquals(4, CatMouse.printSavedMouse(mouseDistance, tomDistance));
	}

}
