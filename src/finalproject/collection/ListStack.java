package finalproject.collection;

import java.util.EmptyStackException;

/**
 * A Stack that is implemented with linked-list abstract data type.
 *
 * @param <E> - the data type of each element in the stack
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 */
public class ListStack<E> extends Stack<E> {
    private ListNode<E> head;
    private int size;

    @Override
    public void push(E e) {
        head = new ListNode<>(e, head);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E returnDatum = peek();
        head = head.getNext();
        size--;
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
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = super.toString() + ": TOS[";
        for (ListNode<E> ln = head; ln != null; ln = ln.getNext()) {
            s += ln.getDatum() + ", ";
        }
        return s + "]";
    }

}
