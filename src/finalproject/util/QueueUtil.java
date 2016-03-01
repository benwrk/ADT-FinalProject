package finalproject.util;

import finalproject.collection.DoublyLinkedListQueue;
import finalproject.collection.ListStack;
import finalproject.collection.Queue;
import finalproject.collection.Stack;

/**
 * Utility for Queues. See {@link Queue} for more.
 *
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 * @see Queue
 */
public class QueueUtil {
    /**
     * Move the given item in the given queue to the front.
     *
     * @param item  is the item to be moved to the front
     * @param queue is the queue to be operated on
     */
    public static <E> void moveToFront(E item, Queue<E> queue) {
        Queue<E> temp = new DoublyLinkedListQueue<>();
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

    /**
     * Reverse the given queue.
     *
     * @param queue is the queue to be reversed
     */
    public static <E> void reverseQueue(Queue<E> queue) {
        Stack<E> stack = new ListStack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
