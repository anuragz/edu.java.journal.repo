package edu.java.journal.basic.generics;

public class Blender<T extends Apple> {
	T obj;
	
	public String blendIt(T arg){		
		System.out.println("Blending "+ arg.toString());
		return arg.blend();
	}
}
