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
     * Decrements the size for the list
     */
    public void decSize() {
        size--;
    }


    /**
     * @return
     *         Gets the head
     */
    public Node<Integer> getHead() {
        return head;
    }


    /**
     * Sets the head of the list
     * 
     * @param head
     *            New head of the list
     */
    public void setHead(Node<Integer> head) {
        this.head = head;
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
     * @param newNode
     *            the node being added to this list
     * @param reviewerTail
     *            the tail of the reviewer list
     */
    public void add(Node<Integer> newNode, Node<Integer> reviewerTail) {

        if (isEmpty()) {
            head = newNode;
            tail = head;
            size++;

            return;
        }
        // Appending the node to the end of the list
        // the previous node
        int val = newNode.getRCount();
        Node<Integer> n = head;

        while (n != null && val > n.getRCount()) {
            n = n.getNextReviewer();
        }
        // tail edge case
        if (n == null) {
            newNode.setNextReviewer(null);
            newNode.setPrevReviewer(tail);
            tail.setNextReviewer(newNode);
            tail = newNode;
        }

        else {
            Node<Integer> pNode = n.getPrevReviewer();
            newNode.setPrevReviewer(pNode);
            newNode.setNextReviewer(n);
            n.setPrevReviewer(newNode);
            // head edge case
            if (pNode != null) {
                pNode.setNextReviewer(newNode);
            }
            else {
                head = newNode;
            }
        }
        size++;
    }


    /**
     * Removes the value at the end of the list
     * 
     * @return Movie<Integer>
     *         the node that is removed
     */
    public Node<Integer> remove() {
        Node<Integer> t = null;
        if (!(isEmpty())) {
            t = tail;
            if (tail != head) {
                Node<Integer> n = tail.getPrevReviewer();
                n.setNextReviewer(null);
                tail.setPrevReviewer(null);
                tail = n;
            }
            size--;
        }
        return t;
    }


    /**
     * Removes the value at the given index
     * 
     * @param val
     *            the position of the record in the list
     * @return Node<Integer>
     *         the node removed
     */
    public Node<Integer> remove(int val) {
        Node<Integer> pNode = head;
        if (head.getValue() == val) {
            head = head.getNextReviewer();
            head.setPrevReviewer(null);
            pNode.setNextReviewer(null);
            size--;
            return pNode;
        }
        while (pNode.getValue() != val) {
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
     * Determines if the list contains a reviewer
     * 
     * @param name
     *            the name of the movie
     * @return Node<Integer>
     *         the node that is of the name or null
     */

    public Node<Integer> containsReviewer(String name) {
        Node<Integer> curr = head;
        while (curr != null) {
            if (curr.getReviewerName().equals(name)) {
                return curr;
            }
            curr = curr.getNextReviewer();
        }
        return null;
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
            currNode = head;
            while (currNode != null) {
                int element = (Integer)currNode.getValue();
                builder.append(element + " ");
                if (currNode != tail) {
                    builder.append(", ");
                }
                currNode = currNode.getNextReviewer();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * Gets the count of the reviewer for the given review and the score in that
     * review
     * 
     * @return String
     *         the count and the score
     */
    public String getCountAndScore() {
        Node<Integer> currNode = null;
        StringBuilder builder = new StringBuilder();
        if (!isEmpty()) {
            currNode = head;
            while (currNode != null) {
                int count = (Integer)currNode.getRCount();
                int score = (Integer)currNode.getValue();
                builder.append(count + ":" + score + " ");
                currNode = currNode.getNextReviewer();
            }
        }
        return builder.toString();
    }


    /**
     * Sets the tail
     * 
     * @param tail
     *            the new tail
     */

    public void setTail(Node<Integer> tail) {
        this.tail = tail;
    }


    /**
     * 
     * @return
     *         Size of the list
     */
    public int getSize() {
        return size;
    }

}
