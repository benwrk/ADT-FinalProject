package finalproject.collection;

public class DoublyLinkedListQueue<E> extends Queue<E> {

	private DoublyLinkedListNode<E> head, tail;
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

	@Override
	public String toString() {
		String s = "Queue HEAD[";
		for (DoublyLinkedListNode<E> h = head; h != null; h = h.getNext()) {
			s += h.getDatum() + ", ";
		}
		return s + "]TAIL " + size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}
}
