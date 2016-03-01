package finalproject.collection;

/**
 * A queue that is implemented using the doubly-linked list abstract data type.
 *
 * @param <E> - data type of each element in the queue
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 * @see finalproject.collection.Queue
 */
public class DoublyLinkedListQueue<E> extends Queue<E> {
    /**
     * The head (or the front) of the queue.
     */
    private DoublyLinkedListNode<E> head;
    /**
     * The tail (or the end) of the queue.
     */
    private DoublyLinkedListNode<E> tail;
    /**
     * Current size of the queue.
     */
    private int size;

    @Override
    public void add(E e) {
        if (isEmpty()) {
            DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(head, e, tail);
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(new DoublyLinkedListNode<>(tail, e, null));
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public E remove() {
        E r = peek();
        if (r == null) {
            throw new IllegalStateException("The queue is empty");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.getNext().setPrevious(null);
            head = head.getNext();
        }
        size--;
        return r;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : head.getDatum();
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Return a String representing this queue and its current elements.
     *
     * @return a String representation of this queue.
     */
    @Override
    public String toString() {
        String s = super.toString() + ": HEAD[";
        for (DoublyLinkedListNode<E> h = head; h != null; h = h.getNext()) {
            s += h.getDatum() + ", ";
        }
        return s + "]TAIL size: " + size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }
}
