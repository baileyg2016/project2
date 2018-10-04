import student.TestCase;

/**
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 2
 */
public class RDLListTest extends TestCase {

    public void SetUp() {
        // Nothing here
    }


    public void testMovieList()  {
        //testing that the list is empty
        RDLList<Integer> list = new RDLList<>();
        assertTrue(list.isEmpty());
        assertNull(list.remove());
        assertEquals(list.size(), 0);
        
        Node<Integer> n = new Node<Integer>(1, null, null, null, null, -1, -1);
        Node<Integer> n1 = new Node<Integer>(2, null, null, null, null, -1, -1);
        Node<Integer> n2 = new Node<Integer>(3, null, null, null, null, -1, -1);
        Node<Integer> tail = new Node<Integer>(-1, null, null, null, null, -1, -1);
        //list.add(n, null);
        assertTrue(list.isEmpty());
        
        list.add(n, tail);        
        assertFuzzyEquals(list.toString(), "{1}");
        
        assertEquals((int)list.remove().getValue(), 1);
        
        list.add(n, tail);
        list.add(n1, n);
        list.add(n2, n1);
        assertFuzzyEquals(list.toString(), "{1, 2, 3}");
        
        assertEquals((int)list.remove(2).getValue(), 2);
        
        assertFuzzyEquals(list.toString(), "{1, 3}");
        
        list.nuke();
        list.trav();
        assertFuzzyEquals(list.toString(), "{}");
        assertTrue(list.isEmpty());
        
        
        list.add(n, tail);
        list.add(n1, n);
        list.add(n2, n1);
        list.remove();
        list.remove();
        list.remove();
    }
}
