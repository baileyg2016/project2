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
        assertEquals(reviewers.contains("Bill").getList().getHead().getValue(),
            6);
        assertEquals(reviewers.contains("Bill").getList().getTail().getValue(),
            3);
        assertEquals(movies.contains("Star wars").getList().getTail()
            .getValue(), 6);
        assertEquals(movies.contains("MOL").getList().getTail().getValue(), 3);
        assertEquals(movies.contains("Star wars").getList().getHead()
            .getValue(), 6);
        assertEquals(movies.contains("MOL").getList().getHead().getValue(), 3);
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
     * THE PROBLEM IS SOMEWHERE IN THIS TEST
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
        matrix.insert("Sergio Leone", "Death Note", 5);
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        matrix.insert("Sergio Leone", "MOL", 6);
        matrix.insert("Darth Vader", "MOL", 9);
        matrix.insert("David Lynch", "MOL", 3);
        matrix.insert("Sergio Leone", "new", 1);
        matrix.insert("Darth Vader", "new", 9);
        matrix.insert("David Lynch", "new", 3);
        assertEquals(13, matrix.getCount());

        System.out.println("Deleted David Lynch\n");
        matrix.deleteReviewers("David Lynch");

        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getValue(), 6);
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getNextReviewer().getValue(), 9);
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getTail()
            .getValue(), 9);
        assertEquals(movies.getList("Death Note").getHead().getValue(), 5);
        assertEquals(movies.getList("Death Note").getHead().getNextReviewer()
            .getValue(), 10);
        assertEquals(movies.getList("Death Note").getTail().getValue(), 10);
        assertEquals(movies.getList("Twin Peaks Returns").getHead().getValue(),
            4);
        assertEquals(movies.getList("Twin Peaks Returns").getHead()
            .getNextReviewer(), null);
        assertEquals(movies.getList("Twin Peaks Returns").getTail().getValue(),
            4);
        // by reviewers
        assertEquals(reviewers.getList("Sergio Leone").getHead().getValue(), 6);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getValue(), 5);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getNextMovie().getValue(), 4);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getNextMovie().getNextMovie().getValue(), 6);
        assertEquals(reviewers.getList("Sergio Leone").getTail().getValue(), 1);

        assertEquals(reviewers.getList("Darth Vader").getHead().getValue(), 9);
        assertEquals(reviewers.getList("Darth Vader").getHead().getPrevMovie(),
            null);
        assertEquals(reviewers.getList("Darth Vader").getTail().getValue(), 9);

        matrix.print();

        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        System.out.println();
        System.out.println("Added another Sergio Leone");
        matrix.print();

        matrix.deleteReviewers("Sergio Leone");
        System.out.println();
        System.out.println("Deleted Sergio Leone");
        matrix.print();

        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        matrix.insert("Sergio Leone", "The Good, the Bad and the Ugly", 10);
        System.out.println();
        System.out.println("Added back Sergio Leone");
        matrix.print();

        matrix.deleteReviewers("Darth Vader");
        System.out.println();
        System.out.println("Deleted Darth Vader");
        matrix.print();

        matrix.deleteMovies("The Good, the Bad and the Ugly");
        System.out.println();
        System.out.println("Deleted Good Bad and Ugly");
        matrix.print();

        matrix.deleteMovies("Death Note");
        System.out.println();
        System.out.println("Deleted Death Note");
        matrix.print();

        matrix.deleteMovies("Twin Peaks Returns");
        System.out.println();
        System.out.println("Deleted Twin Peaks Returns");
        matrix.print();

        assertEquals(matrix.getCount(), 2);
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
        matrix.insert("Sergio Leone", "Death Note", 5);
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        assertEquals(7, matrix.getCount());

        movies.contains("Twin Peaks Returns");
        reviewers.contains("Sergio Leone");

        matrix.deleteMovies("The Good, the Bad and the Ugly");
        assertEquals(movies.getList("Death Note").getHead().getValue(), 5);
        assertEquals(movies.getList("Death Note").getHead().getNextReviewer()
            .getValue(), 10);
        assertEquals(movies.getList("Death Note").getTail().getValue(), 10);
        assertEquals(movies.getList("Twin Peaks Returns").getHead().getValue(),
            4);
        assertEquals(movies.getList("Twin Peaks Returns").getHead()
            .getNextReviewer().getValue(), 5);
        assertEquals(movies.getList("Twin Peaks Returns").getTail().getValue(),
            5);
        // by reviewers
        assertEquals(reviewers.getList("Sergio Leone").getHead().getValue(), 5);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getValue(), 4);
        assertEquals(reviewers.getList("Sergio Leone").getTail().getValue(), 4);
        assertEquals(reviewers.getList("David Lynch").getHead().getValue(), 5);
        assertEquals(reviewers.getList("David Lynch").getHead().getNextMovie(),
            null);
        assertEquals(reviewers.getList("David Lynch").getTail().getValue(), 5);

        assertEquals(reviewers.getList("Darth Vader").getHead().getValue(), 10);
        assertEquals(reviewers.getList("Darth Vader").getHead().getPrevMovie(),
            null);
        assertEquals(reviewers.getList("Darth Vader").getHead().getNextMovie(),
            null);
        assertEquals(reviewers.getList("Darth Vader").getTail().getValue(), 10);
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
        matrix.insert("Sergio Leone", "Death Note", 5);
        matrix.insert("Sergio Leone", "Twin Peaks Returns", 4);
        assertEquals(7, matrix.getCount());

        movies.contains("Twin Peaks Returns");
        reviewers.contains("Sergio Leone");

        matrix.deleteReviewers("Darth Vader");
        // by movies
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getValue(), 6);
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getNextReviewer().getValue(), 3);
        assertEquals(movies.getList("Death Note").getHead().getValue(), 5);
        assertEquals(movies.getList("Death Note").getTail().getValue(), 5);
        // by reviewers
        assertEquals(reviewers.getList("Sergio Leone").getHead().getValue(), 6);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getValue(), 5);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getNextMovie().getValue(), 4);
        assertEquals(reviewers.getList("Sergio Leone").getTail().getValue(), 4);
        assertEquals(reviewers.getList("David Lynch").getHead().getValue(), 3);
        assertEquals(reviewers.getList("David Lynch").getHead().getNextMovie()
            .getValue(), 5);
        assertEquals(reviewers.getList("David Lynch").getTail().getValue(), 5);

        matrix.insert("Darth Vader", "Twin Peaks Returns", 10);
        matrix.insert("Darth Vader", "Death Note", 9);
        matrix.insert("Darth Vader", "The Good, the Bad and the Ugly", 2);
        // by movies
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getValue(), 6);
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getNextReviewer().getValue(), 3);
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getHead()
            .getNextReviewer().getNextReviewer().getValue(), 2);
        assertEquals(movies.getList("The Good, the Bad and the Ugly").getTail()
            .getValue(), 2);
        assertEquals(movies.getList("Death Note").getHead().getValue(), 5);
        assertEquals(movies.getList("Death Note").getHead().getNextReviewer()
            .getValue(), 9);
        assertEquals(movies.getList("Death Note").getTail().getValue(), 9);
        assertEquals(movies.getList("Twin Peaks Returns").getHead().getValue(),
            4);
        assertEquals(movies.getList("Twin Peaks Returns").getHead()
            .getNextReviewer().getValue(), 5);
        assertEquals(movies.getList("Twin Peaks Returns").getTail().getValue(),
            10);
        // by reviewers
        assertEquals(reviewers.getList("Sergio Leone").getHead().getValue(), 6);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getValue(), 5);
        assertEquals(reviewers.getList("Sergio Leone").getHead().getNextMovie()
            .getNextMovie().getValue(), 4);
        assertEquals(reviewers.getList("Sergio Leone").getTail().getValue(), 4);
        assertEquals(reviewers.getList("David Lynch").getHead().getValue(), 3);
        assertEquals(reviewers.getList("David Lynch").getHead().getNextMovie()
            .getValue(), 5);
        assertEquals(reviewers.getList("David Lynch").getTail().getValue(), 5);

        assertEquals(reviewers.getList("Darth Vader").getHead().getValue(), 2);
        assertEquals(reviewers.getList("Darth Vader").getHead().getNextMovie()
            .getValue(), 9);
        assertEquals(reviewers.getList("Darth Vader").getHead().getNextMovie()
            .getNextMovie().getValue(), 10);
        assertEquals(reviewers.getList("Darth Vader").getTail().getValue(), 10);

        matrix.deleteReviewers("David Lynch");

        matrix.deleteReviewers("Sergio Leone");

        assertFalse(matrix.isEmpty());

        matrix.deleteMovies("The Good, the Bad and the Ugly");
        matrix.deleteMovies("Death Note");
        matrix.deleteMovies("Twin Peaks Returns");
        assertEquals(matrix.isEmpty(), true);
    }


    /**
     * Deleting when there is a next movie in the SLList
     */
    /**
     * tests deletes and adds
     */
    public void testDeletesWithMovies() {
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

        assertEquals(matrix.getMovies().getCount(), 3);
        assertEquals(matrix.getReviewers().getCount(), 3);

        assertEquals(matrix.isEmpty(), false);
        matrix.deleteMovies("Death Note");
        matrix.deleteMovies("The Good, the Bad and the Ugly");
        matrix.deleteMovies("Twin Peaks Returns");
        assertEquals(matrix.isEmpty(), true);
    }


    /**
     * Testing deleting
     */
    public void testDeleting() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("0", "0", 5);
        matrix.insert("0", "1", 4);
        matrix.insert("0", "2", 5);
        matrix.insert("1", "0", 3);
        matrix.insert("1", "1", 2);
        matrix.insert("1", "2", 10);
        matrix.deleteMovies("1");

        assertEquals(movies.getList("0").getHead().getValue(), 5);
        assertEquals(movies.getList("0").getHead().getNextReviewer().getValue(),
            3);
        assertEquals(movies.getList("1"), null);
        assertEquals(movies.getList("2").getHead().getValue(), 5);
        assertEquals(movies.getList("2").getHead().getNextReviewer().getValue(),
            10);
        assertEquals(movies.getList("0").getHead().getValue(), 5);
        assertEquals(movies.getList("0").getHead().getNextReviewer().getValue(),
            3);
        assertEquals(reviewers.getList("0").getHead().getValue(), 5);
        assertEquals(reviewers.getList("0").getHead().getNextMovie().getValue(),
            5);
        assertEquals(reviewers.getList("1").getHead().getValue(), 3);
        assertEquals(reviewers.getList("1").getHead().getNextMovie().getValue(),
            10);
    }


    /**
     * testing deleting once again
     */
    public void testDeleteAgain() {
        ReviewerList reviewers = new ReviewerList();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);

        matrix.insert("0", "0", 5);
        matrix.insert("0", "1", 4);
        matrix.insert("1", "0", 3);
        matrix.insert("1", "1", 2);
        matrix.deleteMovies("1");

        assertNull(movies.getList("1"));
    }

}
