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
    private String name;
    /**
     * Whether or not the record has been deleted from the table
     */
    private boolean tombstone;

    /**
     * Holds the list for this movie
     */
    private T list;


    /**
     * The constructor for the record objects
     * 
     * @param key
     *            The key to insert this into the hashTable
     * @param list
     *            The list stored in this record
     */
    public Record(String name, T list) {
        this.name = name;
        this.tombstone = false;
        this.list = list;
    }


    /**
     * Sets the key for the record
     * 
     * @param key
     *            The key for the record to be stored into the hashTable
     */
    public void setKey(String name) {
        this.name = name;
    }


    /**
     * 
     * @return
     *         The key of the record
     */
    public String getKey() {
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
     * Adds a review score to this records list
     * 
     * @param n
     *            The node containing the score
     */
    public void add(Node<Integer> n) {
        list.add(n);
    }


    /**
     * Remove a review from this list
     * 
     * @return Node<Integer>
     *         the node that was removed
     */
    public Node<Integer> remove() {
        return list.remove();
    }


    /**
     * Remove a review from this list
     * 
     * @param name
     *            the name of the item to be removed
     * @return Node<T>
     *         the node that was removed
     */
    public Node<Integer> remove(String name) {
        return list.remove(name);
    }
}
