package finalproject.collection;

/**
 * Interface of Stacks.
 *
 * @param <E> is data type of each elements in the Stack
 * @author Benjapol Worakan 5710546577
 * @version 16.2.22
 */
public abstract class Queue<E> {

    /**
     * Insert an element into the Queue.
     *
     * @param e is an element to be inserted to the Queue
     */
    public abstract void add(E e);

    /**
     * Get and remove an element in front of the Queue.
     *
     * @return An element in front of the Queue.
     */
    public abstract E remove();

    /**
     * Get an element in front of the Queue without removing it from the Queue.
     *
     * @return An element in front of the Queue.
     */
    public abstract E peek();

    /**
     * Test whether if the Queue is empty.
     *
     * @return true if the Queue is empty.
     */
    public abstract boolean isEmpty();

    /**
     * Get the current size of the Queue.
     *
     * @return The current size of the Queue.
     */
    public abstract int size();

    /**
     * Clear all elements in the Queue.
     */
    public abstract void clear();

    public void moveBackToFront() {
        for (int i = 0; i < size() - 1; i++) {
            add(remove());
        }
    }
}
