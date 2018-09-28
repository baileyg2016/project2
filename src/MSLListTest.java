import student.TestCase;

/**
 * 
 * @author Adam Tapp and Bailey Spell
 * @version Milestone 2
 */
public class MSLListTest extends TestCase {

    public void setUp() {

    }


    public void testMSLList() {
        MSLList list = new MSLList();

        assertTrue(list.isEmpty());
        list.add("bobby");
        assertFalse(list.isEmpty());
        assertFuzzyEquals(list.toString(), "{ bobby }");

        assertEquals(list.contains("bobby").getName(), "bobby");
        assertNull(list.contains("a"));
        Node<Integer> node = new Node<>(1, null, null, null, null);
        list.contains("bobby").getList().add(node);

        assertEquals(list.contains("bobby").getList().size(), 1);
        assertFuzzyEquals(list.contains("bobby").getList().toString(), "{1}");

        list.add("Ronnie");
        assertFuzzyEquals(list.toString(), "{ bobby, Ronnie }");

        list.remove("bobby");
        assertFuzzyEquals(list.toString(), "{ Ronnie }");

        list.add("bobby");
        list.add("Jill");
        list.add("Adam");

        assertFuzzyEquals(list.toString(), "{ Ronnie, bobby, Jill, Adam }");
        list.remove("Adam");
        assertFuzzyEquals(list.toString(), "{ Ronnie, bobby, Jill }");
        assertNull(list.remove("bob"));
        
        
        
        list.remove("Ronnie");
        list.remove("bobby");
        list.remove("Jill");
    }

}
