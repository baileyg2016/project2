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
     * The key for the hashTable that corresponds to the record
     */
    private T key;
    /**
     * Whether or not the record has been deleted from the table
     */
    private boolean tombstone;

    /**
     * Points to the head of the list
     */
    private Object h;
    
    /**
     * The constructor for the record objects
     * 
     * @param key
     *            The key to insert this into the hashTable
     */
    public Record(T key) {
        this.key = key;
        this.tombstone = false;
    }


    /**
     * Sets the key for the record
     * 
     * @param key
     *            The key for the record to be stored into the hashTable
     */
    public void setKey(T key) {
        this.key = key;
    }


    /**
     * 
     * @return
     *         The key of the record
     */
    public T getKey() {
        return key;
    }
    
    /**
     * sets the reference to the head node of the list
     */
   public void setH(Node<Integer> head) {
       h = head;
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
}