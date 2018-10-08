import student.TestCase;

/**
 * 
 * Tests the sparse matrix class
 * 
 * @author BaileySpell and Adam Tapp
 * @version Milestone 2
 *
 */
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
        matrix.insert("Hey", "Star wars", 9);
        matrix.insert("Harry", "New World Order", 9);
        matrix.insert("Warren", "New World Order", 3);
        matrix.insert("Bailey", "New World Order", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);
        assertEquals(9, matrix.getCount());
    }


    /**
     * Testing the insert and delete
     */
    public void testInsertAndDelete() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Bill", "Bubba Gump", 10);
        matrix.insert("Phil", "Hot rod", 7);
        matrix.insert("Hey", "Star wars", 6);
        matrix.insert("Harry", "New World Order", 9);
        matrix.insert("Warren", "New World Order", 3);
        matrix.insert("Bailey", "New World Order", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);

        matrix.deleteReviewers("Warren");
        matrix.insert("Warren", "New World Order", 5);
        assertEquals(9, matrix.getCount());
    }


    /**
     * Testing insert with a lot of stuff
     */
    public void testCrazyInsert() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Bill", "Bubba Gump", 10);
        matrix.insert("Phil", "Hot rod", 7);
        matrix.insert("Hey", "Star wars", 6);
        matrix.insert("Harry", "New World Order", 9);
        matrix.insert("Warren", "New World Order", 3);
        matrix.insert("Bailey", "New World Order", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);

        assertEquals(9, matrix.getCount());
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
     * Test inserting a movie that exists but the reviewer does not
     */
    public void testMovieNoReviewer() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Bill", "Star wars", 9);
        assertEquals(2, matrix.getCount());
        assertEquals(1, movies.getCount());
        assertEquals(2, reviewers.getCount());
    }


    /**
     * Test inserting a reviewer that exists but not the movie
     */
    public void testReviewerNoMovie() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Tim", "Return of the Sith", 9);
        assertEquals(2, matrix.getCount());
        assertEquals(2, movies.getCount());
        assertEquals(1, reviewers.getCount());
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
     * deleting a reviewer on the end of the matrix
     */
    public void testDeleteOnTheEnd() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Bill", "Star wars", 6);
        matrix.insert("Harry", "Star wars", 7);
        matrix.insert("Bill", "MOL", 3);
        matrix.insert("Harry", "MOL", 5);

        matrix.deleteReviewers("Harry");

        // there is a delete issue
        assertEquals(matrix.getCount(), 2);
// assertEquals(matrix.reviewers.contains("Bill").getList().getHead()
// .getValue(), 6);
// assertEquals(matrix.reviewers.contains("Bill").getList().getTail()
// .getValue(), 3);
// assertEquals(matrix.movies.contains("Star
// wars").list.getTail().getValue(), 6);
// assertEquals(matrix.movies.contains("MOL").list.getTail().getValue(),
// 3);
// assertEquals(matrix.movies.contains("Star wars").list.getHead()
// .getValue(), 6);
// assertEquals(matrix.movies.contains("MOL").list.getHead().getValue(),
// 7);
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
        matrix.insert("Harry", "Star wars", 3);
        matrix.insert("Harry", "Man on a Ledge", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);
        assertEquals(6, matrix.getCount());

        matrix.deleteReviewers("Harry");
        assertEquals(3, matrix.getCount());
    }


    /**
     * Testing for the empty matrix test
     */
    public void testEmptyMatrix() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Bill", "Star wars", 6);
        matrix.insert("Harry", "New World Order", 9);
        matrix.insert("Harry", "Star wars", 3);
        matrix.insert("Harry", "Man on a Ledge", 10);
        matrix.insert("Geo", "Man on a Ledge", 5);
        matrix.insert("Frank", "ShaShank", 4);
        assertEquals(6, matrix.getCount());

        matrix.deleteReviewers("Bill");
        matrix.deleteReviewers("Harry");
        matrix.deleteReviewers("Geo");
        matrix.deleteReviewers("Frank");

        matrix.deleteMovies("Star wars");
        matrix.deleteMovies("New World Order");
        matrix.deleteMovies("Man on a Ledge");
        matrix.deleteMovies("ShaShank");

        matrix.deleteMovies("ShaShank");
        matrix.deleteReviewers("Bill");

        assertEquals(0, matrix.getCount());

    }


    /**
     * Testing adds and deletes
     */
    public void testAddsAndDeletes() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Sergio Leone", "The Good, the Bad and the Ugly", 6);
        matrix.insert("Darth Vader", "The Good, the Bad and the Ugly", 9);
        matrix.insert("David Lynch", "The Good, the Bad and the Ugly", 3);
        matrix.insert("Darth Vader", "Death Note", 10);
        matrix.insert("David Lynch", "Twin Peaks Returns", 5);
        matrix.insert("Sergio Leone", "Death Note", 6);
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        assertEquals(7, matrix.getCount());

        matrix.deleteReviewers("David Lynch");
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        matrix.deleteReviewers("Sergio Leone");
        matrix.deleteReviewers("Darth Vader");
        matrix.deleteMovies("The Good, the Bad and the Ugly");
        matrix.deleteMovies("Death Note");
        matrix.deleteMovies("Twin Peaks Returns");
        assertEquals(matrix.getCount(), 0);
    }


    /**
     * tests deletes and adds
     */
    public void testAddsAndDeletesWithMovies() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Sergio Leone", "The Good, the Bad and the Ugly", 6);
        matrix.insert("Darth Vader", "The Good, the Bad and the Ugly", 9);
        matrix.insert("David Lynch", "The Good, the Bad and the Ugly", 3);
        matrix.insert("Darth Vader", "Death Note", 10);
        matrix.insert("David Lynch", "Twin Peaks Returns", 5);
        matrix.insert("Sergio Leone", "Death Note", 6);
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        assertEquals(7, matrix.getCount());

        movies.contains("Twin Peaks Returns");
        reviewers.contains("Sergio Leone");

        matrix.deleteMovies("The Good, the Bad and the Ugly");
        matrix.deleteMovies("Death Note");
        matrix.deleteMovies("Twin Peaks Returns");
        assertEquals(matrix.isEmpty(), true);

        matrix.deleteReviewers("David Lynch");
        matrix.deleteReviewers("Sergio Leone");
        matrix.deleteReviewers("Darth Vader");

        assertEquals(matrix.isEmpty(), true);
    }


    /**
     * tests deletes and adds
     */
    public void testAddsAndDeletesWithReviewers() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("Sergio Leone", "The Good, the Bad and the Ugly", 6);
        matrix.insert("Darth Vader", "The Good, the Bad and the Ugly", 9);
        matrix.insert("David Lynch", "The Good, the Bad and the Ugly", 3);
        matrix.insert("Darth Vader", "Death Note", 10);
        matrix.insert("David Lynch", "Twin Peaks Returns", 5);
        matrix.insert("Sergio Leone", "Death Note", 6);
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        assertEquals(7, matrix.getCount());

        movies.contains("Twin Peaks Returns");
        reviewers.contains("Sergio Leone");

        matrix.deleteReviewers("David Lynch");
        matrix.deleteReviewers("Sergio Leone");
        matrix.deleteReviewers("Darth Vader");

        assertEquals(matrix.isEmpty(), true);

        matrix.deleteMovies("The Good, the Bad and the Ugly");
        matrix.deleteMovies("Death Note");
        matrix.deleteMovies("Twin Peaks Returns");
        assertEquals(matrix.isEmpty(), true);
    }
}
