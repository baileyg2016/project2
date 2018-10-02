import student.TestCase;

/**
 * 
 */

/**
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 *
 */
public class ParserTest extends TestCase {

    /**
     * Testing the parser
     */
    public void testParser() {
        Hash<String> movies = new Hash<String>(10);
        Hash<String> reviewers = new Hash<String>(10);
        ReviewerList reviewersList = new ReviewerList();
        MSLList moviesList = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewersList, moviesList);
        Parser parser = new Parser("P2SampleInput.txt", movies, reviewers, reviewersList, moviesList, matrix);
        parser.parseFile();
        assertEquals(2, movies.getCount());
        assertEquals(2, reviewers.getCount());
    }
}
