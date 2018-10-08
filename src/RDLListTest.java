import student.TestCase;

/**
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 */
public class RDLListTest extends TestCase {
    /**
<<<<<<< HEAD
     * Tests the class
=======
     * Set up
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Testing the RDLList
>>>>>>> 820f3a4b0b5707947983fc7768dea1083287bf08
     */
    public void testMovieList() {
        // testing that the list is empty
        RDLList<Integer> list = new RDLList<>();
        assertTrue(list.isEmpty());
        assertNull(list.remove());
        assertEquals(list.size(), 0);

        Node<Integer> n = new Node<Integer>(1, null, null, null, null, 1, 1);
        Node<Integer> n1 = new Node<Integer>(2, null, null, null, null, 2, 2);
        Node<Integer> n2 = new Node<Integer>(3, null, null, null, null, 3, 3);
        Node<Integer> tail = new Node<Integer>(-1, null, null, null, null, -1,
            -1);
        assertTrue(list.isEmpty());
        assertFuzzyEquals(list.toString(), "{}");
        list.add(n, tail);
        assertFuzzyEquals(list.toString(), "{1}");

        assertEquals((int)list.remove().getValue(), 1);

        list.add(n, tail);
        list.add(n1, n);
        list.add(n2, n1);
        assertFuzzyEquals(list.toString(), "{1, 2, 3}");

        assertEquals((int)list.remove(2).getValue(), 2);

        assertFuzzyEquals(list.toString(), "{1, 3}");

        list.remove();
        list.remove();

        n = new Node<Integer>(1, null, null, null, null, 1, 1);
        n1 = new Node<Integer>(3, null, null, null, null, 3, 3);
        n2 = new Node<Integer>(2, null, null, null, null, 2, 2);
        tail = new Node<Integer>(-1, null, null, null, null, -1, -1);

        list.add(n, tail);
        list.add(n1, n);
        list.add(n2, n1);
        list.remove();
        list.remove();
        list.remove();
    }
}
