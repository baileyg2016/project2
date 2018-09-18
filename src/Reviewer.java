
public class Reviewer<T> extends Node<T> {

    public Reviewer(
        T value,
        Node<T> nextReviewer,
        Node<T> prevReviewer,
        Node<T> nextMovie,
        Node<T> prevMovie) {
        super(value, nextReviewer, prevReviewer, nextMovie, prevMovie);
    }
}
