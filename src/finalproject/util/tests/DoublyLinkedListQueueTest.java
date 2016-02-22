package finalproject.util.tests;

import finalproject.collection.DoublyLinkedListQueue;

public class DoublyLinkedListQueueTest {
	public static void main(String[] args) {
		DoublyLinkedListQueue<String> dllq = new DoublyLinkedListQueue<>();
		dllq.add("A");
		System.out.println(dllq);
		dllq.add("B");
		System.out.println(dllq);
		dllq.add("C");
		System.out.println(dllq);
		dllq.add("D");
		System.out.println(dllq);
		dllq.add("E");
		System.out.println(dllq);
		dllq.add("F");
		System.out.println(dllq);
		System.out.println(dllq.remove());
		System.out.println(dllq);
		System.out.println(dllq.remove());
		System.out.println(dllq);
		System.out.println(dllq.remove());
		System.out.println(dllq);
		System.out.println(dllq.remove());
		System.out.println(dllq);
		System.out.println(dllq.remove());
		System.out.println(dllq);
		System.out.println(dllq.remove());
		System.out.println(dllq);
	}
}
