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
        matrixNode.setMCount(movieNode.getCount());

        // Adding the matrix node and connecting everything

        reviewerNode.getList().add(matrixNode, movieTail);
        movieNode.getList().add(matrixNode, reviewerTail);

        count++;
    }


    /**
     * Deletes all the reviews from a movie going reviewer by reviewer
     * 
     * @param name
     *            Name of the reviewer
     */
    public void deleteMovies(String name) {
        // the node in the linked list that contains the movie
        MSLList.Node node = movies.contains(name);
        if (node == null) {
            return;
        }
        // the head of the reviewer list
        ReviewerList.Node head = reviewers.getHead();
        if (head == null) {
            movies.remove(name);
            return;
        }
        // the current node that is in the matrix
        Node<Integer> curr = head.getList().containsMovie(name);

        while (head != null) {
            if (curr == null) {
                head = head.getNext();
                if (head == null) {
                    break;
                }
                curr = head.getList().containsMovie(name);
                continue;
            }

            if (curr.getPrevMovie() == null) {
                if (head.getList().getHead() == head.getList().getTail()) {
                    head.getList().setHead(null);
                    head.getList().setTail(null);
                }
                else {
                    head.getList().setHead(curr.getNextMovie());
                    curr.getNextMovie().setPrevMovie(null);
                }
            }
            else {
                if (curr.getNextMovie() == null) {
                    curr.getPrevMovie().setNextMovie(null);
                    head.getList().setTail(curr.getPrevMovie());
                }
                else {
                    curr.getPrevMovie().setNextMovie(curr.getNextMovie());
                    curr.getNextMovie().setPrevMovie(curr.getPrevMovie());
                }
            }
            head.getList().decSize();
            head = head.getNext();
            if (head == null) {
                count--;
                break;
            }
            curr = head.getList().containsMovie(name);
            count--;
        }
        movies.remove(name);
    }


    /**
     * Deletes all the reviews from a reviewer going movie by movie
     * 
     * @param name
     *            The name of the reviewer
     */
    public void deleteReviewers(String name) {
        // the node in the linked list that contains the reviewer
        ReviewerList.Node node = reviewers.contains(name);
        if (node == null) {
            return;
        }
        // the head of the reviewer list
        MSLList.Node head = movies.getHead();
        if (head == null) {
            reviewers.delete(name);
            return;
        }
        // the current node that is in the matrix
        Node<Integer> curr = head.getList().containsReviewer(name);

        while (head != null) {
            if (curr == null) {
                head = head.getNext();
                if (head == null) {
                    break;
                }
                curr = head.getList().containsReviewer(name);
                continue;
            }

            if (curr.getPrevReviewer() == null) {
                if (head.getList().getHead() == curr) {
                    if (head.getList().getHead() == head.getList().getTail()) {
                        head.getList().setHead(null);
                        head.getList().setTail(null);
                    }
                    else {
                        head.getList().setHead(curr.getNextReviewer());
                        curr.getNextReviewer().setPrevReviewer(null);
                    }
                }
            }
            else {
                if (curr.getNextReviewer() == null) {
                    curr.getPrevReviewer().setNextReviewer(null);
                    head.getList().setTail(curr.getPrevReviewer());
                }
                else {
                    curr.getPrevReviewer().setNextReviewer(curr
                        .getNextReviewer());
                    curr.getNextReviewer().setPrevReviewer(curr
                        .getPrevReviewer());
                }
            }
            head.getList().decSize();
            head = head.getNext();
            if (head == null) {
                count--;
                break;
            }
            curr = head.getList().containsReviewer(name);
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


    /**
     * The print used for testing
     */
    public void print() {
        reviewers.printListAndCount();
        System.out.print(movies.printListAndReviews());
    }
}
