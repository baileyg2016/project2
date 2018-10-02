import student.TestCase;

public class SparseMatrixTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // nothing here
    }


    /**
     * Testing the insert
     */
    public void testInsert() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Bill", "Bubba Gump", 10);
        matrix.insert("Phil", "Hot rod", 7);
        assertEquals(3, matrix.getCount());
    }


    /**
     * Testing if a reviewer updated the rating of a movie
     */
    public void testUpdateRatingWithReviewer() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Tim", "Hot Rod", 9);
        matrix.insert("Tim", "Star wars", 1);
        matrix.insert("Tim", "Hot Rod", 1);
        assertEquals(2, matrix.getCount());
    }


    /**
     * Testing if a reviewer updated the rating of a movie
     */
    public void testUpdateRatingWithMovies() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Bill", "Star wars", 6);
        matrix.insert("Harry", "Star wars", 9);
        matrix.insert("Bill", "Star wars", 1);
        matrix.insert("Harry", "Star wars", 1);
        assertEquals(2, matrix.getCount());
    }


    /**
     * Testing the delete function for a movie node
     */
    public void testDeleteWithMovies() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Bill", "Star wars", 6);
        matrix.insert("Harry", "New World Order", 9);
        matrix.insert("Warren", "New World Order", 3);
        matrix.insert("Bailey", "New World Order", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);
        assertEquals(6, matrix.getCount());

        matrix.deleteMovies("New World Order");
        assertEquals(3, matrix.getCount());
    }


    /**
     * Testing the delete function for a movie node
     */
    public void testDeleteWithReviewers() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Bill", "Star wars", 6);
        matrix.insert("Harry", "New World Order", 9);
        matrix.insert("Harry", "Star Wars", 3);
        matrix.insert("Harry", "Man on a Ledge", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);
        assertEquals(6, matrix.getCount());

        matrix.deleteMovies("New World Order");
        assertEquals(3, matrix.getCount());
    }
}
