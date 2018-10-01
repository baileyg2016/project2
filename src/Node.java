/**
 * 
 */

/**
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 *
 * @param <T>
 *            The generic type
 */
public class Node<T> {
    private Node<T> nextReviewer;
    private Node<T> prevReviewer;
    private Node<T> nextMovie;
    private Node<T> prevMovie;
    private int value;


    
    /**
     * The constructor
     * 
     * @param value
     *            The rating being stored
     * @param nextReviewer
     *            The pointer to the next reviewer
     * @param prevReviewer
     *            The pointer to the previous reviewer
     * @param nextMovie
     *            the pointer to the next movie
     * @param prevMovie
     *            The pointer to the previous movie
     * 
     */
    public Node(int value) {
        this.value = value;
        this.nextReviewer = null;
        this.prevReviewer = null;
        this.nextMovie = null;
        this.prevMovie = null;
    }
    
    
    /**
     * The constructor
     * 
     * @param value
     *            The rating being stored
     * @param nextReviewer
     *            The pointer to the next reviewer
     * @param prevReviewer
     *            The pointer to the previous reviewer
     * @param nextMovie
     *            the pointer to the next movie
     * @param prevMovie
     *            The pointer to the previous movie
     * 
     */
    public Node(
        int value,
        Node<T> nextReviewer,
        Node<T> prevReviewer,
        Node<T> nextMovie,
        Node<T> prevMovie) {
        this.value = value;
        this.nextReviewer = nextReviewer;
        this.prevReviewer = prevReviewer;
        this.nextMovie = nextMovie;
        this.prevMovie = prevMovie;
    }


    /**
     * 
     * @return
     *         The next reviewer
     */
    public Node<T> getNextReviewer() {
        return this.nextReviewer;
    }


    /**
     * 
     * @return
     *         The previous reviewer
     */
    public Node<T> getPrevReviewer() {
        return this.prevReviewer;
    }


    /**
     * 
     * @return
     *         The next movie
     */
    public Node<T> getNextMovie() {
        return this.nextMovie;
    }


    /**
     * 
     * @return
     *         the previous movie
     */
    public Node<T> getPrevMovie() {
        return this.prevMovie;
    }


    /**
     * Set the next reviewer
     * 
     * @param next
     *            The next reviewer to point to
     */
    public void setNextReviewer(Node<T> next) {
        this.nextReviewer = next;
    }


    /**
     * Set the previous reviewer
     * 
     * @param prev
     *            The previous reviewer to point to
     */
    public void setPrevReviewer(Node<T> prev) {
        this.prevReviewer = prev;
    }


    /**
     * Set the next movie
     * 
     * @param next
     *            The next movie to point to
     */
    public void setNextMovie(Node<T> next) {
        this.nextMovie = next;
    }


    /**
     * Set the previous movie
     * 
     * @param prev
     *            The previous movie to point to
     */
    public void setPrevMovie(Node<T> prev) {
        this.prevMovie = prev;
    }


    /**
     * 
     * @return
     *         The value of the node (rating)
     */
    public int getValue() {
        return this.value;
    }


    /**
     * Sets the value (rating) for the node
     * 
     * @param value
     *            The rating of the node
     */
    public void setValue(int value) {
        this.value = value;
    }
}
