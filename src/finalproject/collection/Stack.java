package finalproject.collection;

/**
 * Interface of Stacks
 *
 * @param <E> is data type of each elements in the Stack
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public interface Stack<E> {
    /**
     * Push an e to the top of the Stack.
     *
     * @param e is an e to be pushed
     */
    void push(E e);

    /**
     * Pop (remove) an element from the top of the Stack.
     *
     * @return element from the top of the Stack
     */
    E pop();

    /**
     * Peek at the top element of the Stack without removing it from the Stack.
     *
     * @return element from the top of the Stack
     */
    E peek();

    /**
     * Test if the Stack is empty.
     *
     * @return true if the Stack is empty
     */
    boolean isEmpty();

    /**
     * Make the Stack empty by clearing all elements.
     */
    void clear();
}
