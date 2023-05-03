package edu.java.journal.basic.generics;

public class GenericFactory<T> {
	
	T obj;
	
	GenericFactory(T o){
		obj = o;
	}
	
	public T getFactoryObject() {
	   return obj;
	}
	
	public void showType() {
		System.out.println("T is a instance of "+ obj.getClass().getName());
	}
	
}
