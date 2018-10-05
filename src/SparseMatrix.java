/**
 * This class creates the sparse matrix for the project
 * 
 * 
 * @author BaileySpell and Adam Tapp
 * @version MileStone 2
 *
 */
public class SparseMatrix {

    /**
     * the global reviewers list
     */
    private ReviewerList reviewers;
    /**
     * the global movies list
     */
    private MSLList movies;
    /**
     * the total count of nodes that are in the matrix
     */
    private int count;


    /**
     * Constructor
     * 
     * @param reviewers
     *            The linked list for the reviewers
     * @param movies
     *            The linked list for the movies
     */
    public SparseMatrix(ReviewerList reviewers, MSLList movies) {
        this.reviewers = reviewers;
        this.movies = movies;
        count = 0;
    }


    /**
     * Inserting a node into the matrix and linked the lists
     * 
     * @param reviewer
     *            The name of the reviewer
     * @param movie
     *            the name of the movie
     * @param rating
     *            the rating that the reviewer gave the movie
     */
    public void insert(String reviewer, String movie, int rating) {
        // the initialization of these depends on if the movies and/reviewers
        // exist
        ReviewerList.Node reviewerNode;
        MSLList.Node movieNode;

        // Need to check if it is not in the matrix before trying to add it
        // if this is true then the person has already rated the movie
        if (movies.contains(movie) != null && reviewers.contains(
            reviewer) != null) {
            // all we need to do is update the node from one of the lists
            reviewerNode = reviewers.contains(reviewer);
            if (reviewerNode.getList().containsMovie(movie) == null) {
                movieNode = movies.contains(movie);
            }
            else {
                reviewerNode.getList().containsMovie(movie).setValue(rating);
                reviewerNode.getList().containsMovie(movie).setRCount(
                    reviewerNode.getCount());
                return;
            }

        } // reviewer exist but the movie does not
        else if (movies.contains(movie) == null && reviewers.contains(
            reviewer) != null) {
            // get the reviewerNode that already exist
            reviewerNode = reviewers.contains(reviewer);
            // adding the movie to the row list
            movieNode = movies.add(movie);

        } // movie exist but the reviewer does not
        else if (movies.contains(movie) != null && reviewers.contains(
            reviewer) == null) {
            // get the reviewerNode that already exist
            reviewerNode = reviewers.insert(reviewer);
            // adding the movie to the row list
            movieNode = movies.contains(movie);

        } // neither already exist
        else {
            reviewerNode = reviewers.insert(reviewer);
            movieNode = movies.add(movie);

        }

        // Getting the tail nodes for the list to add to connect the list
        Node<Integer> movieTail = movieNode.getList().getTail();
        Node<Integer> reviewerTail = reviewerNode.getList().getTail();

        // Creating the node to place in the matrix
        Node<Integer> matrixNode = new Node<Integer>(rating, reviewer, movie);

        matrixNode.setRCount(reviewerNode.getCount());
        matrixNode.setMCount(movieNode.getCount()/*
                                                  * movieTail.getMCount() + 1
                                                  */);

        // Adding the matrix node and connecting everything

        reviewerNode.getList().add(matrixNode, movieTail);
        movieNode.getList().add(matrixNode, reviewerTail);

        count++;
    }


    /**
     * Deletes all the movies from a reviewer
     * 
     * @param name
     *            Name of the reviewer
     */
    public void deleteMovies(String name) {
        MSLList.Node node = movies.contains(name);
        Node<Integer> movieNode = node.getList().getHead();
        Node<Integer> next;
        while (movieNode != null) {
            next = movieNode.getNextReviewer();
            if (movieNode.getPrevMovie() == null || movieNode.getPrevMovie()
                .getValue() == -1) {
                if (reviewers.contains(movieNode.getReviewerName()).getList()
                    .getHead() == reviewers.contains(movieNode
                        .getReviewerName()).getList().getTail()) {
                    reviewers.contains(movieNode.getReviewerName()).getList()
                        .setHead(null);
                    reviewers.contains(movieNode.getReviewerName()).getList()
                        .setTail(null);
                }
                else {
                    reviewers.contains(movieNode.getReviewerName()).getList()
                        .setHead(movieNode.getNextMovie());
                }
            }
            else {
                movieNode.getPrevMovie().setNextMovie(movieNode.getNextMovie());
                if (movieNode.getNextMovie() != null) {
                    movieNode.getNextMovie().setPrevMovie(movieNode
                        .getPrevMovie());
                }
            }
            reviewers.contains(movieNode.getReviewerName()).getList().decSize();

            movieNode.setNextReviewer(movieNode.getNextReviewer());
            movieNode = next;
            count--;
        }
        movies.remove(name);
    }


    /**
     * Deletes all the reviews from a reviewer
     * 
     * @param name
     *            The name of the reviewer
     */
    public void deleteReviewers(String name) {
        ReviewerList.Node node = reviewers.contains(name);
        Node<Integer> reviewerNode = node.getList().getHead();
        Node<Integer> next;
        while (reviewerNode != null) {
            next = reviewerNode.getNextMovie();
            if (reviewerNode.getPrevReviewer() == null || reviewerNode
                .getPrevReviewer().getValue() == -1) {
                if (movies.contains(reviewerNode.getMovieName()).getList()
                    .getHead() == movies.contains(reviewerNode.getMovieName())
                        .getList().getTail()) {
                    movies.contains(reviewerNode.getMovieName()).getList()
                        .setHead(null);
                    movies.contains(reviewerNode.getMovieName()).getList()
                        .setTail(null);
                }
                else {
                    movies.contains(reviewerNode.getMovieName()).getList()
                        .setHead(reviewerNode.getNextMovie());
                }
            }
            else {
                reviewerNode.getPrevReviewer().setNextReviewer(reviewerNode
                    .getNextReviewer());
                if (reviewerNode.getNextReviewer() != null) {
                    reviewerNode.getNextReviewer().setPrevReviewer(reviewerNode
                        .getPrevReviewer());
                }
            }
            movies.contains(reviewerNode.getMovieName()).getList().decSize();

            reviewerNode.setNextMovie(reviewerNode.getNextMovie());
            reviewerNode = next;
            count--;
        }
        reviewers.delete(name);
    }


    /**
     * Gets the reviewer list
     * 
     * @return ReviewerList
     *         the list of reviewers
     */
    public ReviewerList getReviewers() {
        return reviewers;
    }


    /**
     * Gets the movie list
     * 
     * @return MSLList
     *         the list of movies
     */
    public MSLList getMovies() {
        return movies;
    }


    /**
     * 
     * @return
     *         whether the matrix is empty of not
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 
     * @return
     *         The number of nodes in the matrix
     */
    public int getCount() {
        return count;
    }
}
