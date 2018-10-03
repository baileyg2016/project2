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
        Hash<String> movies = new Hash<String>(6);
        Hash<String> reviewers = new Hash<String>(6);
        ReviewerList reviewersList = new ReviewerList();
        MSLList moviesList = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewersList, moviesList);
        Parser parser = new Parser("P2SampleInput.txt", movies, reviewers, reviewersList, moviesList, matrix);
        parser.parseFile();
        assertEquals(4, movies.getNumEntries());
        assertEquals(4, reviewers.getNumEntries());
    }
}
