package edu.java.journal.basic.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GenericFactoryTest {

	@Test
	public void blenderAppleTest() {
		Blender<Apple> blender = new Blender<>();
		assertEquals("Apple Juice", blender.blendIt(new Apple()));
		assertTrue(blender instanceof Blender);
	}

	@Test
	public void genericfactoryGetObject() {
		GenericFactory<Integer> gFactory = new GenericFactory<>(1);
		assertTrue(gFactory.getFactoryObject() instanceof Integer);

		GenericFactory<String> gStrFactory = new GenericFactory<>("hello");
		assertTrue(gStrFactory.getFactoryObject() instanceof String);
	}

}
