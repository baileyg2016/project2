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
    /**
     * The next Reviewer
     */
    private Node<T> nextReviewer;
    /**
     * The prev Reviewer
     */
    private Node<T> prevReviewer;
    /**
     * The next Movie
     */
    private Node<T> nextMovie;
    /**
     * The prev Movie
     */
    private Node<T> prevMovie;
    private int value;
    private String movieName;
    private String reviewerName;


    /**
     * The constructor
     * 
     * @param value
     *            The rating being stored
     * @param reviewer
     *            The name of the reviewer
     * @param movie
     *            The name of the movie
     * 
     */
    public Node(int value, String reviewer, String movie) {
        this.value = value;
        this.movieName = movie;
        this.reviewerName = reviewer;
        this.nextReviewer = null;
        this.prevReviewer = null;
        this.nextMovie = null;
        this.prevMovie = null;
    }

    /**
     * The count of the movie this review was added to
     * This is the count of movieTable
     */
    private T mCount;

    /**
     * The count of the review this movie was added to
     * This is the count of reviewTable
     */
    private T rCount;


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
     * @param mCount
     *            The y coord for the node
     * @param rCount
     *            the x coord for the node
     * 
     */
    public Node(
        int value,
        Node<T> nextReviewer,
        Node<T> prevReviewer,
        Node<T> nextMovie,
        Node<T> prevMovie,
        T mCount,
        T rCount) {
        this.value = value;
        this.nextReviewer = nextReviewer;
        this.prevReviewer = prevReviewer;
        this.nextMovie = nextMovie;
        this.prevMovie = prevMovie;
        this.mCount = mCount;
        this.rCount = rCount;
    }


    /**
     * Gets the next Reviewer
     * 
     * @return Node<T>
     *         The next reviewer
     */
    public Node<T> getNextReviewer() {
        return this.nextReviewer;
    }


    /**
     * Gets the previous Reviewer
     * 
     * @return Node<T>
     *         The previous reviewer
     */
    public Node<T> getPrevReviewer() {
        return this.prevReviewer;
    }


    /**
     * Gets the next movie
     * 
     * @return Node<T>
     *         The next movie
     */
    public Node<T> getNextMovie() {
        return this.nextMovie;
    }


    /**
     * gets the previous movie
     * 
     * @return Node<T>
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
     * Gets the value of this node
     * 
     * @return T
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


    /**
     * @return
     *         movie name
     */
    public String getMovieName() {
        return movieName;
    }


    /**
     * @return
     *         reviewer name
     */
    public String getReviewerName() {
        return reviewerName;
    }


    /**
     * Sets the count value
     * 
     * @param count
     *            the count of this reviewer
     */
    public void setMCount(T count) {
        this.mCount = count;
    }


    /**
     * Gets the count value
     * 
     * @return T
     *         the count value
     */
    public T getMCount() {
        return mCount;
    }


    /**
     * Sets the count value
     * 
     * @param count
     *            the count of this reviewer
     */
    public void setRCount(T count) {
        this.rCount = count;
    }


    /**
     * Gets the count value
     * 
     * @return T
     *         the count value
     */
    public T getRCount() {
        return rCount;
    }
}
