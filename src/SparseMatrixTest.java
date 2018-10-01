import student.TestCase;
public class SparseMatrixTest extends TestCase{
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
        ReviewerList<String> reviewers = new ReviewerList<String>();
        MSLList movies = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewers, movies);
        
        reviewers.insert("Tim");
        movies.add("Star wars");
        
        matrix.insert("Tim", "Star wars", 6);
        matrix.insert("Bill", "Bubba Gump", 10);
        matrix.insert("Phil", "Hot rod", 7);
        assertEquals(3, matrix.getCount());
    }
}
