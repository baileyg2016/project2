/**
 * 
 * @author BaileySpell and Adam Tapp
 * @version Milesstone 1
 * 
 *          The movie node for the listing of the sparse matrix
 *
 * @param <T>
 *            The generic types
 */
public class Movie<T> extends Node<T> {
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
    public Movie(
        T value,
        Node<T> nextReviewer,
        Node<T> prevReviewer,
        Node<T> nextMovie,
        Node<T> prevMovie) {
        super(value, nextReviewer, prevReviewer, nextMovie, prevMovie);
    }
}
