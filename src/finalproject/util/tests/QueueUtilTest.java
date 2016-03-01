package finalproject.util.tests;

import finalproject.collection.DoublyLinkedListQueue;
import finalproject.collection.Queue;
import finalproject.util.QueueUtil;

public class QueueUtilTest {
	public static void main(String[] args) {
		Queue<String> q = new DoublyLinkedListQueue<>();
		q.add("1");
		q.add("2");
		q.add("3");
		q.add("4");
		q.add("5");
	
		System.out.println(q);
//		
//		QueueUtil.moveToFront("3", q);
//		
//		System.out.println(q);
//		
//		QueueUtil.reverseQueue(q);
//		
//		System.out.println(q);
		
		q.moveBackToFront();
		
		System.out.println(q);
	}
}
