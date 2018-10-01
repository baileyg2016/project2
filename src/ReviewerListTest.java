import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class ReviewerListTest extends TestCase {
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
        ReviewerList list = new ReviewerList();
        list.insert("Billy");
        list.insert("bobby");
        list.insert("sup");
        list.insert("dog");
        list.insert("hey");
        list.printList();
        assertEquals(5, list.getCount());
    }
}
