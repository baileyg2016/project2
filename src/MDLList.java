/**
 * WE WILL NEED TO MAKE DIFFERENT LISTS BECAUSE OF DIFFERENCES WITH THE POINTERS
 */

/**
 * This provides implementation for some of the LList methods.
 *
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 * 
 * @param <Integer>
 *            The type of object the class will store
 */
public class MDLList<T> {

    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list
     *
     * @param <T>
     *            This is the type of object that this class will store
     * @author Adam Tapp and Bailey Spell
     * @version Milestone 2
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
     * Create a new DLList object.
     */
    public MDLList() {
        head = new Node<Integer>(-1, tail, null, null, null);
        tail = new Node<Integer>(-1, null, head, null, null);
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
     * Gets the head 
     */
    public Node<Integer> getHead() {
        return head;
    }
    

    /**
     * Adds the object to the end of the list
     * 
     * @param node
     *          the node being added to this list
     */
    public void add(Node<Integer> node) {
        // pNode is the the last node inserted
        // the head node if size == 0
        Node<Integer> pNode = tail.getPrevReviewer();
        node.setPrevReviewer(pNode);
        node.setNextReviewer(tail);
        pNode.setNextReviewer(node);
        tail.setPrevReviewer(node);
        size++;

    }


    /**
     * Removes the value at the end of the list
     * 
     * @return Movie<Integer>
     *         the node that is removed
     */
    public Node<Integer> remove() {
        Node<Integer> pNode = tail.getPrevReviewer();
        pNode.getPrevReviewer().setNextReviewer(tail);
        tail.setPrevReviewer(pNode.getPrevReviewer());
        pNode.setNextReviewer(null);
        pNode.setPrevReviewer(null);
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
            pNode = pNode.getNextReviewer();
        }
        pNode.getPrevReviewer().setNextReviewer(pNode.getNextReviewer());
        pNode.getNextReviewer().setPrevReviewer(pNode.getPrevReviewer());
        pNode.setNextReviewer(null);
        pNode.setPrevReviewer(null);
        size--;
        return pNode;
    }


    /**
     * Removes the connections from this list
     */
    public void nuke() {

        Node<Integer> currNode = head.getNextReviewer();
        while (!(currNode.equals(tail))) {
            if (currNode.getNextMovie() != null) {
                currNode.getPrevMovie().setNextMovie(currNode.getNextMovie());
                currNode.getNextMovie().setPrevMovie(currNode.getPrevMovie());
            }
            currNode.setNextMovie(null);
            currNode.setPrevMovie(null);
            currNode = currNode.getNextReviewer();
        }
        size = 0;
    }


    /**
     * Traverses the list
     * Used for the similar call
     */
    public void trav() {
        Node<Integer> currNode = head.getNextReviewer();
        while (currNode != tail) {
            // Maybe add all the scores in the nodes?
            currNode = currNode.getNextReviewer();
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
            currNode = head.getNextReviewer();
            while (currNode != tail) {
                int element = (Integer)currNode.getValue();
                builder.append(element + " ");
                if (currNode.getNextReviewer() != tail) {
                    builder.append(", ");
                }
                currNode = currNode.getNextReviewer();
            }
        }

        builder.append("}");
        return builder.toString();
    }

}
