package finalproject.collection;

/**
 * Interface of Stacks.
 *
 * @param <E> is data type of each elements in the Stack
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
public abstract class Stack<E> {
    /**
     * Push an e to the top of the Stack.
     *
     * @param e is an e to be pushed
     */
    public abstract void push(E e);

    /**
     * Pop (remove) an element from the top of the Stack.
     *
     * @return element from the top of the Stack
     */
    public abstract E pop();

    /**
     * Peek at the top element of the Stack without removing it from the Stack.
     *
     * @return element from the top of the Stack
     */
    public abstract E peek();

    /**
     * Test if the Stack is empty.
     *
     * @return true if the Stack is empty
     */
    public abstract boolean isEmpty();

    /**
     * Make the Stack empty by clearing all elements.
     */
    public abstract void clear();

    /**
     * Get the current size of this Stack.
     *
     * @return the current size of this Stack.
     */
    public abstract int size();

    /**
     * Transfer all elements, except for duplicates, from another Stack
     * to this one. If the source Stack contains no duplicates, it will
     * be emptied, or else the duplicated items will remain there.
     *
     * @param s is the Stack with the elements that are to be added to this Stack
     */
    public void addWithoutDuplicates(Stack<E> s) {
        ListStack<E> t = new ListStack<>();
        while (!s.isEmpty()) {
            E e = s.pop();
            if (contains(e)) {
                t.push(e);
            } else {
                push(e);
            }
        }
        while (!t.isEmpty()) {
            s.push(t.pop());
        }
    }

    /**
     * Test whether the Stack contains the given item.
     *
     * @param item is the item to be searched for
     * @return true if this Stack contained item, false otherwise.
     */
    public boolean contains(E item) {
        ListStack<E> s = new ListStack<>();
        boolean b = false;
        while (!isEmpty()) {
            if (peek().equals(item)) {
                b = true;
            }
            s.push(pop());
        }
        while (!s.isEmpty()) {
            push(s.pop());
        }
        return b;
    }

    /**
     * Remove the element at the bottom of Stack.
     */
    public void removeBottom() {
        Stack<E> temp = new ListStack<>();
        while (!isEmpty()) {
            temp.push(pop());
        }
        temp.pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
    }
}
