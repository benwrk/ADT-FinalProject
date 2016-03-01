package finalproject.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked list abstract data types.
 *
 * @param <E> - data type of each element in the list
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 */
public class LinkedList<E> implements Iterable<E> {
    /**
     * Head of the list.
     */
    private ListNode<E> head;
    /**
     * Current size of the list.
     */
    private int size;

    @Override
    public LinkedListIterator<E> iterator() {
        return iterator(0);
    }

    /**
     * A recursive helper for the {@link #iterator(int)}.
     */
    private LinkedListIterator<E> iterator(int index, ListNode<E> head) {
        if (head == null) {
            return null;
        }
        if (index == 0) {
            return new LinkedListIterator<>(head);
        }
        return iterator(index - 1, head.getNext());
    }

    /**
     * Get the Iterator of this list, starting from the given index.
     *
     * @param index is the index for the Iterator to be initiated on
     * @return the Iterator of this list, starting at the given index.
     * @throws IndexOutOfBoundsException if the given index is invalid.
     */
    public LinkedListIterator<E> iterator(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return iterator(index, head);
    }

    /**
     * A recursive helper for the {@link #add(Object)}.
     */
    private void add(E e, ListNode<E> head) {
        if (head.getNext() == null) {
            head.setNext(new ListNode<>(e, head.getNext()));
        } else {
            add(e, head.getNext());
        }
    }

    /**
     * Add an element to the end of the list.
     *
     * @param e is an element to be added
     */
    public void add(E e) {
        if (head == null) {
            head = new ListNode<>(e, null);
        } else {
            add(e, head);
        }
        size++;
    }

    /**
     * A recursive helper for the {@link #add(int, Object)}.
     */
    private void add(int index, E e, ListNode<E> head) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 1) {
            head.setNext(new ListNode<>(e, head.getNext()));
        } else {
            add(index - 1, e, head.getNext());
        }
    }

    /**
     * And an element to a certain position (index) in the list.
     *
     * @param index is used to specify an index for the element
     * @param e     is an element to be added
     */
    public void add(int index, E e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = new ListNode<>(e, head);
        } else {
            add(index, e, head);
        }
        size++;
    }

    /**
     * A recursive helper for the {@link #remove(int)}.
     */
    private E remove(int index, ListNode<E> head) {
        if (head.getNext() == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 1) {
            E datum = head.getNext().getDatum();
            head.setNext(head.getNext().getNext());
            size--;
            return datum;
        }
        return remove(index - 1, head.getNext());
    }

    /**
     * Remove the element at the given index from the list.
     *
     * @param index is the index of the element to be removed
     * @return the removed element.
     */
    public E remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            E datum = head.getDatum();
            head = head.getNext();
            size--;
            return datum;
        }
        return remove(index, head);
    }

    /**
     * Clear all elements in the list.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * A recursive helper for the {@link #indexOf(Object)}.
     */
    private int indexOf(Object o, ListNode<E> head, int index) {
        if (head == null) {
            return -1;
        }
        if (head.getDatum().equals(o)) {
            return index;
        }
        return indexOf(o, head.getNext(), index + 1);
    }

    /**
     * Get the list index of the given item.
     *
     * @param o is the item to search for its index
     * @return index of the given item, or -1 if the given item is not in the list.
     */
    public int indexOf(Object o) {
        if (o == null) {
            return -1;
        }
        return indexOf(o, head, 0);
    }

    /**
     * A recursive helper for the {@link #contains(Object)}.
     */
    private boolean contains(Object o, ListNode<E> head) {
        return head != null && ((head.getDatum().equals(o) || contains(o, head.getNext())));
    }

    /**
     * Test whether if this list contains the given item.
     *
     * @param o is the item to be searched for
     * @return true if this list contained the given item, false otherwise.
     */
    public boolean contains(Object o) {
        return o != null && contains(o, head);
    }

    /**
     * A recursive helper for the {@link #get(int)}.
     */
    private E get(int index, ListNode<E> head) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.getDatum();
        }
        return get(index - 1, head.getNext());
    }

    /**
     * Get the element in the list that has the given index.
     *
     * @param index is the index of the element
     * @return an item in the list that has the given index.
     * @throws IndexOutOfBoundsException if the given index is invalid or out of range.
     */
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return get(index, head);
    }

    /**
     * Get the first element of the list.
     *
     * @return the first element of the list
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public E get() {
        return get(0);
    }

    /**
     * A recursive helper for the {@link #remove(Object)}.
     */
    private boolean remove(Object o, ListNode<E> head) {
        if (head.getNext() == null) {
            return false;
        }
        if (head.getNext().getDatum().equals(o)) {
            head.setNext(head.getNext().getNext());
            size--;
            return true;
        }
        return remove(o, head.getNext());
    }

    /**
     * Removes the element that is being pointed to by the Iterator from this list.
     *
     * @param it is the Iterator that is pointing to the element that is to be removed
     * @return the given Iterator that is moved to the element right after the removed element.
     */
    public LinkedListIterator<E> remove(LinkedListIterator<E> it) {
        E item = it.next();
        remove(item);
        return it;
    }

    /**
     * A recursive helper for the {@link #reverse()}.
     */
    private void reverse(ListNode<E> node, ListNode<E> previousNode) {
        if (node == null) {
            return;
        }
        ListNode<E> next = node.getNext();
        node.setNext(previousNode);
        if (next == null) {
            head = node;
        }
        reverse(next, node);
    }

    /**
     * Reverse the order of the elements in this list.
     */
    public void reverse() {
        reverse(head, null);
    }

    /**
     * Remove the given element from the list.
     *
     * @param o is the element to be removed from the list.
     * @return true if the given element was successfully removed, false otherwise.
     */
    public boolean remove(Object o) {
        if (head == null || o == null) {
            return false;
        }
        if (head.getDatum().equals(o)) {
            head = head.getNext();
            size--;
            return true;
        }
        return remove(o, head);
    }

    /**
     * Get the tail node of this list.
     */
    private ListNode<E> findTail(ListNode<E> head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        return findTail(head.getNext());
    }

    /**
     * Append another linked-list right after the end of this list.
     *
     * @param list is the list to be appended
     */
    public void append(LinkedList<E> list) {
        if (head == null) {
            head = list.head;
        } else {
            findTail(head).setNext(list.head);
        }
    }

    /**
     * Test whether if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Get the current size of this list.
     *
     * @return current size of this list.
     */
    public int size() {
        return size;
    }

    /**
     * Return a String representing this list and its current elements.
     *
     * @return a String representation of this list.
     */
    @Override
    public String toString() {
        String r = super.toString() + ": [";
        for (ListNode<E> n = head; n != null; n = n.getNext()) {
            r += n.getDatum() + ", ";
        }
        return r + "] size: " + size;
    }

    /**
     * The Iterator of the linked-list.
     *
     * @param <T> - data type of each element in the list
     * @author Benjapol Worakan 5710546577
     * @version 16.3.2
     */
    public class LinkedListIterator<T> implements Iterator<T> {
        /**
         * A currently interested node (just like a cursor).
         */
        private ListNode<T> currentNode;

        /**
         * Construct a new LinkedListIterator.
         *
         * @param head is the head for the Iterator to start on
         */
        private LinkedListIterator(ListNode<T> head) {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T datum = currentNode.getDatum();
            currentNode = currentNode.getNext();
            return datum;
        }

        /**
         * Set the new datum for the element that this Iterator is currently pointing to.
         *
         * @param datum is the new datum for the element
         */
        public void set(T datum) {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements left in the iterator!");
            }
            currentNode.setDatum(datum);
        }
    }
}
