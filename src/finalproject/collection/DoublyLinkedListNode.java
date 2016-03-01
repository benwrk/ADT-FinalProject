package finalproject.collection;

/**
 * A node of a doubly-linked list.
 *
 * @param <T> - data type of the data in the node
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 */
class DoublyLinkedListNode<T> {
    /**
     * A reference to the node prior to this node.
     */
    private DoublyLinkedListNode<T> previous;
    /**
     * A reference to the node right after this node.
     */
    private DoublyLinkedListNode<T> next;
    /**
     * A data element that is contained in this node.
     */
    private T datum;

    /**
     * Construct a new node.
     *
     * @param previous is the reference to the node prior to this node
     * @param datum    is the datum that is to be contained within this node
     * @param next     is the reference to the node right after this node
     */
    public DoublyLinkedListNode(DoublyLinkedListNode<T> previous, T datum,
                                DoublyLinkedListNode<T> next) {
        this.previous = previous;
        this.datum = datum;
        this.next = next;
    }

    /**
     * Get the reference to the node prior to this node.
     *
     * @return the reference to the node prior to this node.
     */
    public DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    /**
     * Set the new reference for the node prior to this node.
     *
     * @param previous is the reference to the node prior to this node
     */
    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Get the reference to the node right after this node.
     *
     * @return the reference to the node right after this node.
     */
    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    /**
     * Set the new reference for the node right after this node.
     *
     * @param next is the reference to the node right after this node
     */
    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    /**
     * Get the data element contained within this node.
     *
     * @return the data element contained within this node.
     */
    public T getDatum() {
        return datum;
    }

    /**
     * Set the new data element to replace the current data element in this node.
     *
     * @param datum is the datum to be contained within this node
     */
    public void setDatum(T datum) {
        this.datum = datum;
    }

}
