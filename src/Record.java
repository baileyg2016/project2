/**
 * This is the abstract class for the record objects
 * that will be reviewers or movies
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 * 
 *
 * @param <T>
 *            The generic type for the class
 */
public class Record<T> {
    /**
     * The Name that corresponds to the container
     * either movie or reviewer
     */
    private T name;


    /**
     * Whether or not the record has been deleted from the table
     */
    private boolean tombstone;

    private Object head;

    /**
     * The constructor for the record objects
     * 
     * @param key
     *            The key to insert this into the hashTable
     *            
     */
    public Record(T name) {
        this.name = name;
        this.tombstone = false;
        this.head = null;
    }


    /**
     * Sets the key for the record
     * 
     * @param key
     *            The key for the record to be stored into the hashTable
     */
    public void setKey(T name) {
        this.name = name;
    }


    /**
     * 
     * @return
     *         The key of the record
     */
    public T getKey() {
        return name;
    }


    /**
     * If the record is deleted set the record as a hashTable
     */
    public void isTombstone() {
        this.tombstone = true;
    }


    /**
     * 
     * @return
     *         Whether or not the record is a tombStone
     */
    public boolean getTombstone() {
        return tombstone;
    }
    
    /**
     * Sets the key for the record
     * 
     * @param key
     *            The key for the record to be stored into the hashTable
     */
    public void setHead(Node<T> node) {
        this.head = node;
    }


    /**
     * 
     * @return
     *         The key of the record
     */
    public Object getHead() {
        return head;
    }
}

