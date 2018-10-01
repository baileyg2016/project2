/**
 * WE WILL NEED TO MAKE DIFFERENT LISTS BECAUSE OF DIFFERENCES WITH THE POINTERS
 */

/**
 * This provides implementation for some of the LList methods.
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 * 
 * @param <T>
 *            The type of object the class will store
 */
public class RDLList<T> {

    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list
     *
     * @param <T>
     *            This is the type of object that this class will store
     * @author Adam Tapp
     * @version 9.18.18
     */

    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<Integer> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<Integer> tail;

    /**
     * Reference to the Movie list
     */
    private RDLList<Node<T>> list;

    /**
     * Create a new DLList object.
     * 
     */
    public RDLList() {
        head = new Node<Integer>(-1, null, null, tail, null, -1, -1);
        tail = new Node<Integer>(-1, null, null, null, head, -1, -1);
        size = 0;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Gets the complimentary list to this one
     */
    public void setReviewerList(RDLList<Node<T>> list) {
        this.list = list;
    }


    /**
     * Gets the complimentary list to this one
     */
    public RDLList<Node<T>> getReviewerList() {
        return list;
    }
    
    /**
     * Gets the head 
     */
    public Node<Integer> getHead() {
        return head;
    }


    /**
     * Adds the object to the end of the list
     * 
     * @param <T>
     * 
     * @param val
     *            the score to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(Node<Integer> node) {
        Node<Integer> pNode = tail.getPrevMovie();
        node.setPrevMovie(pNode);
        node.setNextMovie(tail);
        pNode.setNextMovie(node);
        tail.setPrevMovie(node);
        size++;
    }


    /**
     * Removes the value at the end of the list
     * 
     * @return Movie<E>
     *         the node that is removed
     */
    public Node<Integer> remove() {
        Node<Integer> pNode = tail.getPrevMovie();
        pNode.getPrevMovie().setNextMovie(tail);
        tail.setPrevMovie(pNode.getPrevMovie());
        pNode.setNextMovie(null);
        pNode.setPrevMovie(null);
        size--;
        return pNode;
    }


    /**
     * Removes the value at the given index
     * 
     * @param val
     *            the position of the record in the list
     */
    public Node<Integer> remove(int val) {
        Node<Integer> pNode = head;
        while (!(pNode.getValue() == val)) {
            pNode = pNode.getNextMovie();
        }
        pNode.getPrevMovie().setNextMovie(pNode.getNextMovie());
        pNode.getNextMovie().setPrevMovie(pNode.getPrevMovie());
        pNode.setNextMovie(null);
        pNode.setPrevMovie(null);
        size--;
        return pNode;
    }


    /**
     * Removes the connections from this list
     */
    public void nuke() {

        Node<Integer> currNode = head.getNextMovie();
        while (!(currNode.equals(tail))) {
            if (currNode.getNextReviewer() != null) {
                currNode.getPrevReviewer().setNextReviewer(currNode
                    .getNextReviewer());
                currNode.getNextReviewer().setPrevReviewer(currNode
                    .getPrevReviewer());
            }
            currNode.setNextReviewer(null);
            currNode.setPrevReviewer(null);
            currNode = currNode.getNextMovie();
        }
        size = 0;
    }


    /**
     * Traverses the list
     * Used for the similar call
     */
    public void trav() {
        Node<Integer> currNode = head.getNextMovie();
        while (currNode != tail) {
            // Maybe add all the scores in the nodes?
            currNode = currNode.getNextMovie();
        }

        // Return the scores added and then divided by the number of nodes?
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        Node<Integer> currNode = null;
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            currNode = head.getNextMovie();
            while (currNode != tail) {
                int element = (Integer)currNode.getValue();
                builder.append(element + " ");
                if (currNode.getNextMovie() != tail) {
                    builder.append(", ");
                }
                currNode = currNode.getNextMovie();
            }
        }

        builder.append("}");
        return builder.toString();
    }

}
