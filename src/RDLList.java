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
     * Create a new DLList object.
     * 
     */
    public RDLList() {
        head = new Node<Integer>(-1, tail, null, null, null, -1, -1);
        tail = new Node<Integer>(-1, null, head, null, null, -1, -1);
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
     * @return
     *         Gets the head
     */
    public Node<Integer> getTail() {
        return tail;
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
    public void add(Node<Integer> newNode, Node<Integer> movieTail) {
        if (isEmpty()) {
            head = newNode;
            tail = head;
            size++;

            //newNode.setPrevReviewer(movieTail);
            if (movieTail != null) {
                //movieTail.setNextReviewer(newNode);
            }
            return;
        }
        // Appending the node to the end of the list
        // the previous node
        int val = newNode.getMCount();
        Node<Integer> n = head;

        while (val > n.getMCount() && n != null) {
            n = n.getNextMovie();
        }
        //tail edge case
        if (n == null) {
            newNode.setNextMovie(null);
            newNode.setPrevMovie(tail);
            tail.setNextMovie(newNode);
            tail = newNode;
        }
        
        else {
            Node<Integer> pNode = n.getPrevMovie();
            newNode.setPrevMovie(pNode);
            newNode.setNextMovie(n);
            //head edge case
            if (pNode != null) {
                pNode.setNextMovie(newNode);
            }
            else {
                head = newNode;
            }
        }
        size++;

        // connecting the node with the other list
        //newNode.setPrevReviewer(movieTail);
       // movieTail.setNextReviewer(newNode);
    }


    /**
     * Removes the value at the end of the list
     * 
     * @return Movie<E>
     *         the node that is removed
     */
    public Node<Integer> remove() {
        Node<Integer> t = null;
        if (!(isEmpty())) {
            t = tail;
            if (tail == head) {
                head = null;
            }
            else {
                Node<Integer> n = tail.getPrevMovie();
                n.setNextMovie(null);
                tail.setPrevMovie(null);
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
     * Determines if the list contains a reviewer
     * 
     * @param name
     *            the name of the reviewer
     * @return Node<Integer>
     *         the node that is of the name or null
     */

    public Node<Integer> containsReviewer(String name) {
        Node<Integer> curr = head;
        while (curr != null) {
            if (curr.getReviewerName().equals(name)) {
                return curr;
            }
            curr = curr.getNextMovie();
        }
        return null;
    }


    /**
     * Determines if the list contains a movie
     * 
     * @param name
     *            the name of the movie
     * @return Node<Integer>
     *         the node that is of the name or null
     */

    public Node<Integer> containsMovie(String name) {
        Node<Integer> curr = head;
        while (curr != null) {
            if (curr.getMovieName().equals(name)) {
                return curr;
            }
            curr = curr.getNextMovie();
        }
        return null;
    }


    /**
     * Removes the connections from this list
     */
    public void nuke() {

        Node<Integer> currNode = head;

        while (currNode != null) {
            if (currNode.getNextReviewer() != null) {
                currNode.getNextReviewer().setPrevReviewer(currNode
                    .getPrevReviewer());
            }
            if (currNode.getPrevReviewer() != null) {
                currNode.getPrevReviewer().setNextReviewer(currNode
                    .getNextReviewer());
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
        Node<Integer> currNode = head;
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
            currNode = head;
            while (currNode != null) {
                int element = (Integer)currNode.getValue();
                builder.append(element + " ");
                if (currNode != tail) {
                    builder.append(", ");
                }
                currNode = currNode.getNextMovie();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * 
     * @param head
     *            Sets the head for the list
     */
    public void setHead(Node<Integer> head) {
        this.head = head;
    }


    /**
     * 
     * @param tail
     *            Sets the tail for the list
     */
    public void setTail(Node<Integer> tail) {
        this.tail = tail;
    }

    /**
     * Gets the count of the reviewer for the given review and the score in that
     * review
     * 
     * @return String
     *         the count and the score
     */
// public String getCountAndScore() {
// Node<Integer> currNode = null;
// StringBuilder builder = new StringBuilder();
// if (!isEmpty()) {
// currNode = head;
// while (currNode != tail) {
// int count = (Integer)currNode.getRCount();
// int score = (Integer)currNode.getValue();
// builder.append(count + ":" + score + " ");
// if (currNode.getNextMovie() != tail) {
// builder.append(", ");
// }
// currNode = currNode.getNextMovie();
// }
// }
// return builder.toString();
// }

}
