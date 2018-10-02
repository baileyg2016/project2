import student.TestCase;

/**
 * 
 * @author Adam Tapp and Bailey Spell
 * @version Milestone 2
 */
public class MSLListTest extends TestCase {

    /**
     * Set up
     */
    public void setUp() {
        // nothing here
    }
    
//    public void testMSLList() {
//        MSLList<Integer> list = new MSLList<>();
//        MDLList<Integer> mList = new MDLList<>();
//        
//        
//        
//        
//        
//    }



    /**
     * The test for MSLList
     */
    public void testMSLList() {
        MSLList list = new MSLList();

        assertTrue(list.isEmpty());
        list.add("bobby");
        assertFalse(list.isEmpty());
        assertFuzzyEquals(list.toString(), "{ bobby }");

        assertEquals(list.contains("bobby").getName(), "bobby");
        assertNull(list.contains("a"));
        Node<Integer> node = new Node<Integer>(1, null, null, null, null, -1, -1);
        Node<Integer> tail = new Node<Integer>(-1, null, null, null, null, -1, -1);
        list.contains("bobby").getList().add(node, tail);

        assertEquals(list.contains("bobby").getList().size(), 1);
        assertFuzzyEquals(list.contains("bobby").getList().toString(), "{1}");

        list.add("Ronnie");
        assertFuzzyEquals(list.toString(), "{ bobby, Ronnie }");

        list.remove("bobby");
        assertFuzzyEquals(list.toString(), "{ Ronnie }");

        list.add("bobby");
        list.add("Jill");
        list.add("Adam");
        
        
        System.out.println(list.printListAndReviews());
        
        assertEquals(list.getList("Adam").getClass(), (new MDLList<Integer>())
            .getClass());
        assertNull(list.getList("Jimmy"));
        
        assertFuzzyEquals(list.toString(), "{ Ronnie, bobby, Jill, Adam }");
        list.remove("Adam");
        assertFuzzyEquals(list.toString(), "{ Ronnie, bobby, Jill }");
        assertNull(list.remove("bob"));

        list.remove("Ronnie");
        list.remove("bobby");
        list.remove("Jill");
        
        System.out.println(list.printListAndReviews());
    }

}
