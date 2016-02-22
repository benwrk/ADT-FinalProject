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

}
