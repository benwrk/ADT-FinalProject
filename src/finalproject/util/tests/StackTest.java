package finalproject.util.tests;

import finalproject.collection.ListStack;
import finalproject.collection.Stack;
import finalproject.util.StackUtil;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> s1 = new ListStack<>();
		Stack<String> s2 = new ListStack<>();
		s1.push("A");
		s1.push("X");
		s1.push("B");
		s1.push("Y");
		s1.push("C");
		s1.push("Z");
		System.out.println(s1);
		s2.push("A");
		s2.push("B");
		s2.push("C");
		s2.push("D");
		s2.push("M");
		s2.push("N");
		s2.push("O");
//		s2.pop();
		s2.push("D");
		s2.push("D");
		s2.push("D");
		s2.push("D");
		s2.push("D");
		s2.push("D");
		System.out.println(s2);
		System.out.println();
		s1.addWithoutDuplicates(s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println();
		StackUtil.sortStack(s1);
		System.out.println(s1);
		StackUtil.sortStack(s2);
		System.out.println(s2);
		System.out.println(s1);
		s1.removeBottom();
		System.out.println(s1);
	}
}
