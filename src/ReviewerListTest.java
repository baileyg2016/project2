import student.TestCase;

/**
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 * @param <T>
 */
public class ReviewerListTest<T> extends TestCase {
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
        assertEquals(list.contains("Billy").getCount(), 0);
        assertNull(list.contains("Joe"));

        list.insert("bobby");
        list.insert("sup");
        list.insert("dog");
        list.insert("hey");
        assertEquals(list.getList("hey").getClass(), RDLList.class);
        assertEquals(list.contains("hey").getCount(), 4);
        assertNull(list.contains("Joe"));
        list.printList();
        list.printListAndCount();
        assertEquals(5, list.getCount());

        list.delete("Billy");
        list.printList();
        list.delete("sup");
        list.delete("dog");
        list.delete("hey");
        list.printList();
        list.delete("bobby");
        list.printList();

        assertNull(list.getList("Joe"));

        ReviewerList list1 = new ReviewerList("Head");

        list1.delete(null);

    }
}
