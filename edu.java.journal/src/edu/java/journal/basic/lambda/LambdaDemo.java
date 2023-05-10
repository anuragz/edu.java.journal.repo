package edu.java.journal.basic.lambda;


interface NumericTest{
	boolean test(int n);
	//String hello();
}

interface PrintHello{
	void hello();
}

interface Sum{
	int operate(int a, int b);
}

interface NumberFunc{
	int func(int n);
}

interface SomeFunc<T>{
	T func(T t);
}

public class LambdaDemo {

	public static void main(String[] args) {
		//1. one argument lambda expression
		NumericTest isEven = (n) -> (n%2)==0;
		if(isEven.test(10)) {
			System.out.println("10 is even");
		}
		//2. no argument
		PrintHello printHello = ()-> System.out.println("hello world !!");
		printHello.hello();
		
		//3. two arguments
		Sum s = (a, b)-> a+b;		
		System.out.println(s.operate(11, 99));
		
		//4. block statement lambda example
		NumberFunc factorial = (n) -> {
			int result =1;
			for(int i=1;i<=n;i++) {
				result = i* result;
			}
			return result;
		};
		System.out.println("Factorial of 5 "+ factorial.func(5));
		
		//5. generic example
		SomeFunc<String> somefunc = (str) -> {
			return "char count is "+str.length();
		};		
		System.out.println(somefunc.func("hello!"));
				
	}
}
