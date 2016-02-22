package finalproject.util.tests;

import finalproject.collection.ArrayStack;

public class ArrayStackTest {
	public static void main(String[] args) {
		ArrayStack<String> as = new ArrayStack<>(2);
		as.push("A");
		System.out.println(as);
		as.push("B");
		as.push("C");
		as.push("D");
		System.out.println(as);
		System.out.println(as.pop());
		System.out.println(as);
		System.out.println(as.peek());
		System.out.println(as);
		as.push("D");
		as.push("D");
		as.push("D");
		as.push("D");
		as.push("D");
		as.push("D");
		System.out.println(as);
	}
}
