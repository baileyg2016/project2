import student.TestCase;
/**
 * 
 * @author Bailey Spell and Adam Tapp 
 * @version Milestone 2
 */
public class RDLListTest extends TestCase {

    public void SetUp() {
      //Nothing here  
    }
    
    public void testMovieList()  {
        //testing that the list is empty
        RDLList<Integer> list = new RDLList<>();
        assertTrue(list.isEmpty());
        assertEquals(list.size(), 0);
        
        Node<Integer> n = new Node<>(1, null, null, null, null, -1, -1);
        Node<Integer> n1 = new Node<>(2, null, null, null, null, -1, -1);
        Node<Integer> n2 = new Node<>(3, null, null, null, null, -1, -1);
        list.add(n);
        assertFalse(list.isEmpty());
        assertFuzzyEquals(list.toString(), "{1}");
        
        assertEquals((int)list.remove().getValue(), 1);
        
        list.add(n);
        list.add(n1);
        list.add(n2);
        assertFuzzyEquals(list.toString(), "{1, 2, 3}");
        
        assertEquals((int)list.remove(2).getValue(), 2);
        
        assertFuzzyEquals(list.toString(), "{1, 3}");
        
        list.nuke();
        list.trav();
        assertFuzzyEquals(list.toString(), "{}");
        assertTrue(list.isEmpty());
    }
}
