 /**
 *
 */


import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * @author Eric
 * @author maellis1
 * @version 11-2-15
 *
 */
public class DLListTest extends TestCase {
    /**
     * the list we will use
     */
    private MDLList<String> list;

    /**
     * The iterator for the list
     */
    private Iterator<String> iter;

    /**
     * The reverse iterator for the list
     */
    private Iterator<String> rIter;

    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new MDLList<String>();
        iter = list.iterator();
        rIter = list.reverseIterator();
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        MDLList<String> emptyList = new MDLList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the has next method
     */
    public void testHasNext() {
        // Case 1: if the list does not have anything in the list
        assertTrue(list.isEmpty());
        assertFalse(iter.hasNext());

        // Case 2: if the list has one entry in the list
        list.add("goats");
        assertTrue(iter.hasNext());

        // Case 3: if the list has more than one entry in the list
        list.add("Cheese");
        assertTrue(iter.hasNext());
    }


    /**
     * Tests next, which returns the next entry in the list
     */
    public void testNext() {
        // Case 1: If the list is empty
        assertTrue(list.isEmpty());
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

        // Case 2: If the list contains one entry
        list.add("Fries");
        assertEquals("Fries", iter.next());

        // Case 3: If the list contains more than one entry
        list.add("Hamburger");
        list.add("Chocolate Shake");
        assertEquals("Hamburger", iter.next());
        assertEquals("Chocolate Shake", iter.next());

    }


    /**
     * Tests remove, which removes an entry
     */
    public void testRemove() {
        // Case 1: If the list is empty
        assertTrue(list.isEmpty());
        try {
            iter.remove();
        }
        catch (IllegalStateException e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }

        // Case 2: If the list has one entry, but next has not been called
        list.add("Potato");
        try {
            iter.remove();
        }
        catch (IllegalStateException e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }

        // Case 3: If the list has one entry and next was called
        assertFalse(list.isEmpty());
        assertEquals("Potato", iter.next());
        iter.remove();
        assertTrue(list.isEmpty());

        // Case 4: If the list has more than one entry and next was called
        iter = list.iterator();
        list.add("Fries");
        list.add("Hamburger");
        list.add("Chocolate Shake");
        assertFalse(list.isEmpty());
        assertEquals("{Fries, Hamburger, Chocolate Shake}", list.toString());
        assertEquals("Fries", iter.next());
        iter.remove();
        assertEquals("{Hamburger, Chocolate Shake}", list.toString());
        assertEquals("Hamburger", iter.next());
        iter.remove();
        assertEquals("Chocolate Shake", iter.next());
        iter.remove();

        assertTrue(list.isEmpty());

    }
    
    /**
     * Tests hasNext()
     */
    public void testRevHasNext() {
        // Case 1: if the list does not have anything in the list
        assertTrue(list.isEmpty());
        assertFalse(rIter.hasNext());

        // Case 2: if the list has one entry in the list
        list.add("goats");
        assertTrue(rIter.hasNext());

        // Case 3: if the list has more than one entry in the list
        list.add("Cheese");
        assertTrue(rIter.hasNext());
    }
    
    /**
     * Tests next()
     */
    public void testRevNext() {
        // Case 1: If the list is empty
        assertTrue(list.isEmpty());
        try {
            rIter.next();
        }
        catch (NoSuchElementException e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

        // Case 2: If the list contains one entry
        list.add("Fries");
        assertEquals("Fries", rIter.next());
        rIter = list.reverseIterator();
        // Case 3: If the list contains more than one entry
        list.add("Hamburger");
        list.add("Chocolate Shake");
        assertEquals("Chocolate Shake", rIter.next());
        assertEquals("Hamburger", rIter.next());  

    }
    

    /**
     * Tests remove, which removes an entry
     */
    public void testRevRemove() {
        // Case 1: If the list is empty
        assertTrue(list.isEmpty());
        try {
            rIter.remove();
        }
        catch (IllegalStateException e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }

        // Case 2: If the list has one entry, but next has not been called
        list.add("Potato");
        try {
            rIter.remove();
        }
        catch (IllegalStateException e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }

        // Case 3: If the list has one entry and next was called
        assertFalse(list.isEmpty());
        assertEquals("Potato", rIter.next());
        rIter.remove();
        assertTrue(list.isEmpty());

        // Case 4: If the list has more than one entry and next was called
        rIter = list.reverseIterator();
        list.add("Fries");
        list.add("Hamburger");
        list.add("Chocolate Shake");
        assertFalse(list.isEmpty());
        assertEquals("{Fries, Hamburger, Chocolate Shake}", list.toString());
        assertEquals("Chocolate Shake", rIter.next());
        rIter.remove();
        assertEquals("{Fries, Hamburger}", list.toString());
        assertEquals("Hamburger", rIter.next());
        rIter.remove();
        assertEquals("Fries", rIter.next());
        rIter.remove();

        assertTrue(list.isEmpty());
    }

    

}
