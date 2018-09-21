/**
 * WE WILL NEED TO MAKE DIFFERENT LISTS BECAUSE OF DIFFERENCES WITH THE POINTERS
 */

/**
 * This provides implementation for some of the LList methods.
 *
 * @author Mark Wiggans (mmw125)
 * @version 3/29/15
 * @author Eric Williamson
 * @version 10/30/15
 * @author maellis1
 * @version 11/1/15
 * @param <E>
 *            The type of object the class will store
 */
public class DLList<E> {

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
    private static class Movie<T> extends Node<T> {

        public Movie(
            T value,
            Node<T> nextReviewer,
            Node<T> prevReviewer,
            Node<T> nextMovie,
            Node<T> prevMovie) {
            super(value, nextReviewer, prevReviewer, nextMovie, prevMovie);
        }

    }

    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Movie<Integer> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Movie<Integer> tail;

    
    /**
     * Reference to the Reviewer list
     */
    private DLList<Node<E>> list;

    /**
     * Create a new DLList object.
     * 
     * @param val
     *            the score for the first review
     */
    public DLList(int val) {
        init(val);
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init(int val) {
        head = new DLList.Movie<Integer>(0, tail, null, null, null);
        tail = new DLList.Movie<Integer>(0, null, head, null, null);
        // head.setNext(tail);
        // tail.setPrevious(head);
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
    public void setReviewerList(DLList<Node<E>> list) {
        this.list = list;
    }
    
    /**
     * Gets the complimentary list to this one
     */
    public DLList<Node<E>> getReviewerList() {
        return list;
    }


    /**
     * Adds the object to the end of the list
     * 
     * @param val
     *            the score to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(Node<Integer> node) {
//        if (val < 1) {
//            throw new IllegalArgumentException("Scores must be between 1-10");
//        }
        
        Movie<Integer> pNode = (Movie<Integer>)tail.getPrevReviewer();
        //Movie<Integer> addition = new Movie<Integer>(val, tail, pNode, null,
        //    null);
        //for ()
        node.setPrevReviewer(pNode);
        node.setNextReviewer(tail);
        pNode.setNextReviewer(node);
        size++;

    }


    /**
     * Removes the connections from this list
     */
    public void nuke() {

        Movie<Integer> currNode = (Movie<Integer>)head.getNextMovie();
        while (currNode != tail) {

            currNode.getPrevReviewer().setNextReviewer(currNode.getNextReviewer());
            currNode.getNextReviewer().setPrevReviewer(currNode.getPrevReviewer());

            currNode.setNextReviewer(null);
            currNode.setPrevReviewer(null);
            currNode = (Movie<Integer>)currNode.getNextReviewer();
        }

    }


    /**
     * Traverses the list
     * Used for the similar call
     */
    public void trav() {
        Movie<Integer> currNode = (Movie<Integer>)head.getNextReviewer();
        while (currNode != tail) {
            // Maybe add all the scores in the nodes?
            currNode = (Movie<Integer>)currNode.getNextReviewer();
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
        Movie<Integer> currNode = null;
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            currNode = (Movie<Integer>)head.getNextReviewer();
            while (currNode != tail) {
                int element = currNode.getValue();
                builder.append(element + " ");
                if (currNode.getNextReviewer() != tail) {
                    builder.append(", ");
                }
                currNode = (Movie<Integer>)currNode.getNextReviewer();
            }
        }

        builder.append("}");
        return builder.toString();
    }

}
