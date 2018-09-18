/**
 * 
 */

/**
 * @author BaileySpell
 *
 */
public abstract class Node<T> {
    private Node<T> nextReviewer;
    private Node<T> prevReviewer;
    private Node<T> nextMovie;
    private Node<T> prevMovie;
    private T value;


    public Node(
        T value,
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


    public Node<T> getNextReviewer() {
        return this.nextReviewer;
    }


    public Node<T> getPrevReviewer() {
        return this.prevReviewer;
    }


    public Node<T> getNextMovie() {
        return this.nextMovie;
    }


    public Node<T> getPrevMovie() {
        return this.prevMovie;
    }


    public void setNextReviewer(Node<T> next) {
        this.nextReviewer = next;
    }


    public void setPrevReviewer(Node<T> prev) {
        this.prevReviewer = prev;
    }


    public void setNextMovie(Node<T> next) {
        this.nextMovie = next;
    }


    public void setPrevMovie(Node<T> prev) {
        this.prevMovie = prev;
    }


    public T getValue() {
        return this.value;
    }


    public void setValue(T value) {
        this.value = value;
    }
}
