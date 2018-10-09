import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class MovieReviewTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testRInit() {
        MovieReview recstore = new MovieReview();
        assertNotNull(recstore);
        MovieReview.main(null);
    }


    /**
     * Testing the main function
     */
    public void testMain() {
        String[] args = new String[3];
        args[0] = "6";
        args[1] = "P2SampleInput.txt";
        MovieReview.main(args);
        
        assertEquals(args[0], "6");
    }
}
