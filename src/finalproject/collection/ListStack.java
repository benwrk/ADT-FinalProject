package finalproject.collection;

import java.util.EmptyStackException;

/**
 * A Stack that is implemented with linked-list abstract data types.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class ListStack<E> extends Stack<E> {
    private ListNode<E> head;

    @Override
    public void push(E e) {
        head = new ListNode<>(e, head);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E returnDatum = peek();
        head = head.getNext();
        return returnDatum;
    }

    @Override
    public E peek() {
        return head.getDatum();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
    }
    
    @Override
    public String toString() {
    	String s = "ListStack TOS[";
    	for (ListNode<E> ln = head; ln != null; ln = ln.getNext()) {
    		s += ln.getDatum() + ", ";
    	}
    	return s + "]";
    }
    
}
