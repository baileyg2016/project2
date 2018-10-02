/**
 * This class creates the sparse matrix for the project
 * 
 * 
 * @author BaileySpell and Adam Tapp
 * @version MileStone 2
 *
 */
public class SparseMatrix {

    // the global reviewers list
    public ReviewerList reviewers;
    // the global movies list
    public MSLList movies;
    // the total count of nodes that are in the matrix
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
            if (reviewerNode.list.containsMovie(movie) != null) {
                reviewerNode.list.containsMovie(movie).setValue(rating);
                return;
            }
            else {
                movieNode = movies.contains(movie);
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
        Node<Integer> movieTail = movieNode.list.getTail();
        Node<Integer> reviewerTail = reviewerNode.list.getTail();

        // Creating the node to place in the matrix
        Node<Integer> matrixNode = new Node<Integer>(rating, reviewer, movie);

        // Adding the matrix node and connecting everything
        reviewerNode.list.add(matrixNode, movieTail);
        movieNode.list.add(matrixNode, reviewerTail);

        count++;
    }


    public void deleteMovies(String name) {
        MSLList.Node node = movies.contains(name);
        Node<Integer> movieNode = node.list.getHead();
        while (movieNode != null) {
            movieNode.setNextReviewer(movieNode.getNextReviewer());
            movieNode = movieNode.getNextMovie();
            count--;
        }
    }


    public void deleteReviewers(String name) {
        ReviewerList.Node node = reviewers.contains(name);
        Node<Integer> reviewerNode = node.list.getHead();
        while (reviewerNode != null) {
            reviewerNode.setNextReviewer(reviewerNode.getNextReviewer());
            reviewerNode = reviewerNode.getNextMovie();
            count--;
        }
    }

    /**
     * Gets the reviewer list
     * @return ReviewerList
     *          the list of reviewers
     */
    public ReviewerList getReviewers() {
        return reviewers;
    }
    
    /**
     * Gets the movie list
     * @return MSLList
     *          the list of movies
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
