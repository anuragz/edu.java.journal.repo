package edu.java.journal.datastructure.graphs;

import java.util.Arrays;

public class CatMouse {

	private static int countSavedMouse(int[] mouseDistance) {
		int mouseSavedCount = 0;
		for (int element : mouseDistance) {
			if (element < 1) {
				mouseSavedCount++;
			}
		}
		return mouseSavedCount;
	}

	public static int printSavedMouse(int[] mouseDistance, int tomDistance) {
		Arrays.sort(mouseDistance);
		int mouseSavedCount = 0;
		mouseDistance[0]--;
		for (int element : mouseDistance) {
			int d = element;
			while ((d >= 1) && (tomDistance > 1)) {
				if (d < tomDistance) {
					d--;
					reduceallduplicate(mouseDistance, element, d);
				}
				tomDistance--;
				if (tomDistance == 1) {
					break;
				}
			}
		}
		// System.out.println(mouseSavedCount);
		mouseSavedCount = countSavedMouse(mouseDistance);
		return mouseSavedCount;
	}

	public static int printSavedMouseOld(int[] mouseDistance, int tomDistance) {
		Arrays.sort(mouseDistance);
		int mouseSavedCount = 0;

		for (int i = 0; i < mouseDistance.length; i++) {

			int d = mouseDistance[i];

			while ((d >= 1) && (tomDistance > 1)) {
				if (d < tomDistance) {// move mouse first
					d--;
				}
				if (0 == d) {
					mouseDistance[i] = 0;
				}
				tomDistance--;// move tom next
			}

			// tom kills all mouse at same index
			for (int j = 0; j < mouseDistance.length; j++) {
				if (mouseDistance[i] == tomDistance) {
					mouseDistance[i] = -1;
					break;
				}
			}
		}

		for (int element : mouseDistance) {// count the saved mouse
			if (element == 0) {
				mouseSavedCount++;
			}
		}

		// System.out.println(mouseSavedCount);
		return mouseSavedCount;
	}

	private static void reduceallduplicate(int[] mouseDistance, int old,
			int newvalue) {
		for (int i = 0; i < mouseDistance.length; i++) {
			if (mouseDistance[i] == old) {
				mouseDistance[i] = newvalue;
			}
		}
	}

}
