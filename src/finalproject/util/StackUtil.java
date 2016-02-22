package finalproject.util;

import finalproject.collection.ListStack;
import finalproject.collection.Stack;

public class StackUtil {
	public static <E extends Comparable<E>> void sortStack(Stack<E> s) {
		Stack<E> t = new ListStack<>();
		while (!s.isEmpty()) {
			t.push(s.pop());
		}
		
		System.out.println("INIT: " + s.toString() + " " + t.toString());
		while (!t.isEmpty()) {
			E e = t.pop();
			while (!s.isEmpty() && s.peek().compareTo(e) < 0) {
				t.push(s.pop());
				System.out.println(e + ": TOS too low (" + t.peek() + "): " + s.toString() + " " + t.toString());
			}
			s.push(e);
			System.out.println(e + ": PUSH: " + s.toString() + " " + t.toString());
		}
	}
}
