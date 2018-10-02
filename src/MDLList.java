/**
 * This provides implementation for some of the LList methods.
 *
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 * 
 * @param <T>
 *            The type of object the class will store
 */
public class MDLList<T> {
    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     * 
     * @param Integer
     *            the value stored in the node
     */
    private Node<Integer> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     * 
     * @param Integer
     *            the value stored in the node
     */
    private Node<Integer> tail;


    /**
     * Create a new DLList object.
     */
    public MDLList() {
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
     * @return
     *         Gets the head
     */
    public Node<Integer> getHead() {
        return head;
    }


    /**
     * @return
     *         Gets the tail
     */
    public Node<Integer> getTail() {
        return tail;
    }


    /**
     * Adds the object to the end of the list
     * 
     * @param node
     *            the node being added to this list
     *            <<<<<<< HEAD
     * @param reviewerTail
     *            the tail of the reviewer list
     *            =======
     *            >>>>>>> origin/PrintList
     */
    public void add(Node<Integer> newNode, Node<Integer> reviewerTail) {
        if (isEmpty()) {
            head = newNode;
            tail = head;
            size++;
            // connecting the node with the other list
            newNode.setPrevReviewer(reviewerTail);
            reviewerTail.setNextMovie(newNode);
            return;
        }
        // appending the node to the end of the list
        // the previous node
        Node<Integer> pNode;
        if (head == tail) {
            pNode = head;
        }
        else {
            pNode = tail.getPrevMovie();
        }
        newNode.setPrevMovie(pNode);
        tail = newNode;
        size++;

        // connecting the node with the other list
        newNode.setPrevReviewer(reviewerTail);
        reviewerTail.setNextMovie(newNode);

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
        if (currNode != null) {
            while (!(currNode.equals(tail))) {
                if (currNode.getNextMovie() != null) {
                    currNode.getPrevMovie().setNextMovie(currNode
                        .getNextMovie());
                    currNode.getNextMovie().setPrevMovie(currNode
                        .getPrevMovie());
                }
                currNode.setNextMovie(null);
                currNode.setPrevMovie(null);
                currNode = currNode.getNextReviewer();
            }
            size = 0;
        }
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


    /**
     * Gets the count of the reviwer for the given review and the score in that
     * review
     * 
     * @return String
     *         the count and the score
     */
    public String getCountAndScore() {
        Node<Integer> currNode = null;
        StringBuilder builder = new StringBuilder();
        if (!isEmpty()) {
            currNode = head.getNextReviewer();
            while (currNode != tail) {
                int count = (Integer)currNode.getRCount();
                int score = (Integer)currNode.getValue();
                builder.append(count + ":" + score + " ");
                if (currNode.getNextReviewer() != tail) {
                    builder.append(", ");
                }
                currNode = currNode.getNextReviewer();
            }
        }
        return builder.toString();
    }

}
