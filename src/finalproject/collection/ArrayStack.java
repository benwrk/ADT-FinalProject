package finalproject.collection;

import java.util.Arrays;

/**
 * A Stack that is implemented with array abstract data types.
 *
 * @author Benjapol Worakan 5710546577
 * @version 16.2.22
 */
public class ArrayStack<E> extends Stack<E> {

	private Object[] array;
	private int size;
	private static final int DEFAULT_SIZE = 10;

	public ArrayStack(int size) {
		array = new Object[size];
	}

	public ArrayStack() {
		this(DEFAULT_SIZE);
	}

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
	public String toString() {
		return "Stack " + Arrays.toString(array) + " " + size;
	}

}
