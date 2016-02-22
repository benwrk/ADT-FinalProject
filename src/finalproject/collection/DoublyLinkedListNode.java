package finalproject.collection;

public class DoublyLinkedListNode<T> {
	private DoublyLinkedListNode<T> previous, next;
	private T datum;

	public DoublyLinkedListNode(DoublyLinkedListNode<T> previous, T datum,
			DoublyLinkedListNode<T> next) {
		this.previous = previous;
		this.datum = datum;
		this.next = next;
	}

	public DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode<T> previous) {
		this.previous = previous;
	}

	public DoublyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode<T> next) {
		this.next = next;
	}

	public T getDatum() {
		return datum;
	}

	public void setDatum(T datum) {
		this.datum = datum;
	}

}
