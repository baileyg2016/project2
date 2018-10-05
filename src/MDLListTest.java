import student.TestCase;

/**
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 */
public class MDLListTest extends TestCase {

    /**
     * Testing movie list
     */
    public void testMovieList() {
        // testing that the list is empty
        MDLList<Integer> list = new MDLList<>();
        assertTrue(list.isEmpty());
        System.out.println(list.getCountAndScore());
        assertEquals(list.size(), 0);
        assertNull(list.remove());

        Node<Integer> n = new Node<Integer>(1, null, null, null, null, -1, -1);
        Node<Integer> n1 = new Node<Integer>(2, null, null, null, null, -1, -1);
        Node<Integer> n2 = new Node<Integer>(3, null, null, null, null, -1, -1);
        Node<Integer> tail = new Node<Integer>(-1, null, null, null, null, -1,
            -1);

        list.add(n, null);
        list.add(n1, null);
        list.add(n2, null);

        System.out.println(list.getCountAndScore());
        assertEquals((int)list.remove(2).getValue(), 2);

        assertFuzzyEquals(list.toString(), "{3, 1}");

        list.nuke();
        list.trav();
        assertFuzzyEquals(list.toString(), "{}");
        assertTrue(list.isEmpty());

        n = new Node<Integer>(1, null, null, null, null, -1, -1);
        n1 = new Node<Integer>(2, null, null, null, null, -1, -1);
        n2 = new Node<Integer>(3, null, null, null, null, -1, -1);
        tail = new Node<Integer>(-1, null, null, null, null, -1, -1);
        list.add(n, tail);
        list.add(n1, n);
        list.add(n2, n1);
        list.nuke();

        n = new Node<Integer>(1, null, null, null, null, -1, -1);
        n1 = new Node<Integer>(2, null, null, null, null, -1, -1);
        n2 = new Node<Integer>(3, null, null, null, null, -1, -1);
        tail = new Node<Integer>(-1, null, null, null, null, -1, -1);
        list.add(n, tail);
        list.add(n1, n);
        list.add(n2, n1);
        list.trav();
        assertEquals((int)list.remove().getValue(), 1);
        assertEquals((int)list.remove().getValue(), 2);
        assertEquals((int)list.remove().getValue(), 3);
    }
}
