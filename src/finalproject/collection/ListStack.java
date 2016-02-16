package finalproject.collection;

import java.util.EmptyStackException;

/**
 * A Stack that is implemented with linked-list abstract data types.
 *
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public class ListStack<E> implements Stack<E> {
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
        E returnDatum = head.getDatum();
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
}
