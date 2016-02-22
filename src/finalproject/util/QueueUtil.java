package finalproject.util;

import finalproject.collection.DoublyLinkedListQueue;
import finalproject.collection.ListStack;
import finalproject.collection.Queue;
import finalproject.collection.Stack;

public class QueueUtil {
	public static <E> void moveToFront(E item, Queue<E> queue) {
		Queue<E> temp = new DoublyLinkedListQueue<E>();
		E match = null;
		
		while (!queue.isEmpty()) {
			E e = queue.remove();
			if (e.equals(item)) {
				match = e;
			} else {
				temp.add(e);
			}
		}

		if (match != null) {
			queue.add(match);
		}
		
		while (!temp.isEmpty()) {
			queue.add(temp.remove());
		}
	}
	
	public static <E> void reverseQueue(Queue<E> queue) {
		Stack<E> stack = new ListStack<E>();
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
}
