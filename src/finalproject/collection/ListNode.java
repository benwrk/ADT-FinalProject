package finalproject.collection;

/**
 * Nodes of a linked-list.
 *
 * @param <T> is the data type of the node's datum
 * @author Benjapol Worakan 5710546577
 * @version 15.12.26
 */
class ListNode<T> {
    private T datum;
    private ListNode<T> next;

    /**
     * Create a new node.
     *
     * @param datum is the datum for the new node
     * @param next  is the next node that is right after this node
     */
    public ListNode(T datum, ListNode<T> next) {
        this.datum = datum;
        this.next = next;
    }

    /**
     * Get the datum of this node.
     *
     * @return datum of this node
     */
    public T getDatum() {
        return datum;
    }

    /**
     * Set this node's datum to a new datum.
     *
     * @param datum is a new datum for this node
     */
    public void setDatum(T datum) {
        this.datum = datum;
    }

    /**
     * Get the node that is right after this node.
     *
     * @return the node right after this node (null if end-of-list)
     */
    public ListNode<T> getNext() {
        return next;
    }

    /**
     * Set this node's next node to be another node.
     *
     * @param next is the node that is to be right after this node
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
