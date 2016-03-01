package finalproject.collection;

import java.util.Arrays;

/**
 * A Stack that is implemented with array abstract data types.
 *
 * @param <E> - the data type of each element in the stack
 * @author Benjapol Worakan 5710546577
 * @version 16.2.22
 */
public class ArrayStack<E> extends Stack<E> {
    /**
     * Default initial capacity of the array.
     */
    public static final int DEFAULT_SIZE = 10;
    /**
     * An array that is used to contain elements.
     */
    private Object[] array;
    /**
     * Indicates current size of the stack.
     */
    private int size;

    /**
     * Construct a new ArrayStack with the given initial capacity.
     *
     * @param capacity is the initial capacity of the stack
     */
    public ArrayStack(int capacity) {
        array = new Object[capacity];
    }

    /**
     * Construct a new ArrayStack with the default initial capacity.
     */
    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Extends the array container by doubling the size.
     */
    private void extendArray() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public void push(E e) {
        if (size >= array.length) {
            extendArray();
        }
        array[size++] = e;
    }

    @Override
    public E pop() {
        E r = peek();
        array[--size] = null;
        return r;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new Object[array.length];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Return a String representing this stack and its current elements.
     *
     * @return a String representation of this stack.
     */
    @Override
    public String toString() {
        return super.toString() + ": " + Arrays.toString(Arrays.copyOf(array, size)) + " size: " + size;
    }
}
