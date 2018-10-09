import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the hash function (you should throw this away for your project)
 *
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 */
public class HashTest extends TestCase {
    /**
     * Sets up the tests that follow.
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Test the hash function
     */
    public void testh() {

        Hash<String> myHash = new Hash<String>(10);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("aaaabbb", 101), 1640219587 % 101);
    }
    
    /**
     * testing the hashing
     */
    public void testHash() {
        Hash<String> myHash = new Hash<String>(10);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("Darth Vader", 6), 0);
        assertEquals(myHash.h("David Lynch", 6), 4);
        
    }


    /**
     * Testing inserting only one
     * record into Table
     */
    public void testInsertOne() {
        Hash<String> table = new Hash<String>(11);
        table.insert("Testing", "Testing");
        assertEquals(table.getCount(), 1);
        assertEquals(table.getSize(), 11);
    }


    /**
     * Test the insert function
     */
    public void testInsert() {
        Hash<String> hash = new Hash<String>(11);
        for (int i = 0; i < 5; i++) {
            hash.insert("Record # " + Integer.toString(i), "Testing");
        }
        // hash.printTable();

        assertEquals(hash.getCount(), 5);
        assertEquals(hash.getSize(), 11);
        assertEquals(hash.getHashTable().getClass(), Record[].class);
        hash.setCount(5);
        assertEquals(hash.getCount(), 5);
    }


    /**
     * Testing for the table to increase once
     */
    public void testGrowth() {
        Hash<String> hash = new Hash<String>(10);
        for (int i = 0; i < 6; i++) {
            hash.insert("Record # " + Integer.toString(i), "Testing");
        }

        assertEquals(hash.getCount(), 6);
        assertEquals(hash.getSize(), 20);
        hash.insert("Recrod # 5" , "Testing");   
        hash.delete("Record # 5", "Testing");
        hash.delete("Record # 5", "Testing");

    }


    /**
     * Testing growth for it to increase twice
     */
    public void testForDoubleGrowth() {
        Hash<String> hash = new Hash<String>(10);
        for (int i = 0; i < 14; i++) {
            hash.insert("Record # " + Integer.toString(i), "Testing");
        }

        assertEquals(hash.getCount(), 14);
        assertEquals(hash.getSize(), 40);

    }


    /**
     * Testing deleting one record
     */
    public void testDelete() {
        Hash<String> hash = new Hash<String>(10);
        for (int i = 0; i < 14; i++) {
            hash.insert("Record # " + Integer.toString(i), "Testing");
        }
        assertEquals(hash.getCount(), 14);

        for (int i = 0; i < 14; i++) {
            hash.delete("Record # " + Integer.toString(i), "Testing");
        }
        assertEquals(hash.getNumEntries(), 0);
        assertEquals(hash.getSize(), 40);
        assertEquals(hash.getCount(), 14);
        
    }


    /**
     * Testing deleting then readding records
     */
    public void testDeleteThenAdd() {
        Hash<String> hash = new Hash<String>(10);
        for (int i = 0; i < 14; i++) {
            hash.insert("Record # " + Integer.toString(i), "Testing");
        }
        assertEquals(hash.getNumEntries(), 14);

        for (int i = 0; i < 14; i++) {
            hash.delete("Record # " + Integer.toString(i), "Testing");
        }
        assertEquals(hash.getNumEntries(), 0);

        for (int i = 0; i < 14; i++) {
            hash.insert("Record # " + Integer.toString(i), "Testing");
        }
        assertEquals(hash.getNumEntries(), 14);
    }


    /**
     * Testing for duplicates
     */
    public void testDulicates() {
        Hash<String> hash = new Hash<String>(10);
        for (int i = 0; i < 4; i++) {
            hash.insert("Record the same", "Testing");
        }
        assertEquals(hash.getNumEntries(), 1);
    }


    /**
     * Deleting something that does not exist
     */
    public void testDeleteDoesNotExist() {
        Hash<String> hash = new Hash<String>(10);
        hash.delete("Tombstones", "Testing");
        assertEquals(hash.getNumEntries(), 0);
    }


    /**
     * Testing the same record different values
     */
    public void testHashing() {
        Hash<String> hash = new Hash<String>(10);
        hash.insert("Tombstones", "Testing");
        hash.insert("Tombstones", "Testing");
        hash.insert("Tombstones", "Testing");

        assertEquals(hash.getCount(), 1);
    }


    /**
     * Testing the tombstones
     */
    public void testStones() {
        Hash<String> hash = new Hash<String>(10);
        hash.insert("Tombstones", "Testing");
        hash.delete("Tombstones", "Testing");
        hash.insert("Tombstones", "Testing");

        assertEquals(hash.getNumEntries(), 1);
    }


    /**
     * Testing records that hash to
     * the same thing.
     */
    public void testSameHash() {
        Hash<String> hash = new Hash<String>(10);
        hash.insert("Record # 1", "Testing");
        hash.delete("Record # 1", "Testing");
        hash.insert("Record # 6", "Testing");

        assertEquals(hash.getNumEntries(), 1);
    }


    /**
     * Testing for the simple add test
     */
    public void testSimpleAdd() {
        Hash<String> hash = new Hash<String>(1);
        hash.insert("Record # 1", "Testing");
        hash.insert("Record # 6", "Testing");
        hash.delete("Record # 1", "Testing");
        hash.delete("Record # 6", "Testing");
        hash.insert("Record # 1", "Testing");
        hash.insert("Record # 6", "Testing");
        assertEquals(hash.getSize(), 4);
    }


    /**
     * Testing growth with tombstones
     */
    public void testGrowthWStones() {
        Hash<String> hash = new Hash<String>(10);
        hash.insert("Record # 1", "Testing");
        hash.insert("Record # 6", "Testing");
        hash.delete("Record # 1", "Testing");
        hash.delete("Record # 6", "Testing");

        assertEquals(hash.getSize(), 10);
        assertEquals(hash.getNumEntries(), 0);
    }


    /**
     * Testing simple SimpleTombHash
     */
    public void testSimpleTombHash() {
        Hash<String> hash = new Hash<String>(4);
        hash.insert("Record # 1", "Testing");
        hash.delete("Record # 1", "Testing");
        hash.insert("Record # 6", "Testing");

        assertEquals(hash.getSize(), 4);
        assertEquals(hash.getNumEntries(), 1);
    }
}
