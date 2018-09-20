/**
 * Stub for hash table class
 *
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 * 
 *
 * @param <T>
 *            The generic type for the keys being stored
 */
public class Hash<T> {

    /**
     * The size of the table
     */
    private int hashTableSize;
    /**
     * The array for the hashTable
     */
    private Record<T>[] hashTable;

    /**
     * The amount of entries in the table
     */
    private int hashTableCount;


    /**
     * Create a new Hash object.
     * 
     * @param size
     *            The initial size of the table
     */
    @SuppressWarnings("unchecked")
    public Hash(int size) {
        // Nothing here yet
        this.hashTableCount = 0;
        this.hashTableSize = size;
        this.hashTable = new Record[size];

    }


    /**
     * 
     * @return
     *         The amount of records in the table
     */
    public int getTableCount() {
        return hashTableCount;
    }


    /**
     * Compute the hash function. Uses the "sfold" method from the OpenDSA
     * module on hash functions
     *
     * @param s
     *            The string that we are hashing
     * @param m
     *            The size of the hash table
     * @return The home slot for that string
     */
    // You can make this private in your project.
    // This is public for distributing the hash function in a way
    // that will pass milestone 1 without change.
    public int h(String s, int m) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int)(Math.abs(sum) % m);
    }


    /**
     * 
     * This performs the quadratic probing discussed
     * in the project specification
     * 
     * @param i
     *            The current index from the home position
     * @return
     *         Returns the new position to add to the home position
     */
    public int probe(int i) {
        return i * i;
    }


    /**
     * Inserts a new record into the hash table
     * 
     * @param key
     *            The name of the reviewer or movie for the location in the hash
     *            table
     * @param tableName
     *            The name of the hashTable that we are inserting to
     */
    public void insert(T key, String tableName) {
        Record<T> record = new Record<T>(key);

        // Grow if we are at half capacity
        if (hashTableCount == hashTableSize / 2) {
            hashTableCount = 0;
            growHT();
            System.out.println(tableName + " hash table " + "size doubled to "
                + hashTableSize + " slots.");
        }

        // If the table is empty as pos
        // and is not a tombstone then insert
        int pos;
        int home = h(record.getKey().toString(), hashTableSize);
        pos = home;
        for (int i = 1; hashTable[pos] != null; i++) {

            if (hashTable[pos].getKey().toString().equals(key.toString())) {
                if (hashTable[pos].getTombstone()) {
                    hashTable[pos] = record;
                    hashTableCount++;
                    return;
                }
                else {
                    // already in here

                    return;
                }

            }

            pos = (home + probe(i)) % hashTableSize;
        }
        hashTable[pos] = record;
        hashTableCount++;

    }


    /**
     * This deletes the record that occurs
     * with the certain Key value.
     * 
     * @param key
     *            The key that is trying to be deleted
     * @param tableName
     *            the name of the table that we are deleting from
     * 
     *
     */
    public void delete(T key, String tableName) {
        int home = h(key.toString(), hashTableSize);
        int pos = 0;

        if (getTableCount() == 0) {
            System.out.println("|" + key + "| not deleted because "
                + "it does not exist in the " + tableName + " database.");
            return;
        }
        int prevCount = hashTableCount;
        // This loop checks to delete the key at
        // a different probe position because it
        // could have been inserted somewhere else
        for (int i = 0; hashTableCount != prevCount - 1; i++) {
            pos = (home + probe(i)) % hashTableSize;

            // if there is nothing there we know that the key
            // does not exist
            if (hashTable[pos] == null) {
                System.out.println("|" + key + "| not deleted because it "
                    + "does not exist in the " + tableName + " database.");
                return;
            }
            // We can delete if the keys are equal and it is
            // not a tombstone
            else if (hashTable[pos].getKey().equals(key) && !hashTable[pos]
                .getTombstone()) {
                hashTable[pos].isTombstone();
                hashTableCount--;
                System.out.println("|" + key + "| has been deleted from the "
                    + tableName + " database.");
            }
        }

    }


    /**
     * This function doubles the size of the table
     */
    @SuppressWarnings("unchecked")
    public void growHT() {
        Record<T>[] temp = this.hashTable;
        hashTableSize *= 2;
        this.hashTable = new Record[hashTableSize];

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null && !temp[i].getTombstone()) {
                insertOnGrow(temp[i].getKey());
            }
        }
    }


    /**
     * This insert is for when I
     * double the table. I only have
     * this because I had a print issue
     * when I was inserting into the new
     * table.
     * 
     * @param key
     *            The record name to be hashed
     */
    public void insertOnGrow(T key) {
        Record<T> record = new Record<T>(key);

        // If the table is empty as pos
        // and is not a tombstone then insert
        int pos;
        int home = h(record.getKey().toString(), hashTableSize);
        pos = home;
        for (int i = 1; hashTable[pos] != null; i++) {
            pos = (home + probe(i)) % hashTableSize;
        }
        hashTable[pos] = record;
        hashTableCount++;
    }


    /**
     * Prints the total amount of records
     * stored within the table
     */
    public void printCount() {
        System.out.println("Total records: " + hashTableCount);
    }


    /**
     * Prints the contents in the hash table
     */
    public void printTable() {
        for (int i = 0; i < hashTableSize; i++) {
            if (hashTable[i] != null && !hashTable[i].getTombstone()) {
                System.out.println("|" + hashTable[i].getKey() + "| " + i);
            }
        }
        printCount();
    }


    /**
     * This returns the size of the table
     * 
     * @return
     *         Returns the variable hashTableSize
     */
    public int getSize() {
        return hashTableSize;
    }


    /**
     * This returns the number of records
     * in the table
     * 
     * @return
     *         Returns the variable hashTableCount
     */
    public int getCount() {
        return hashTableCount;
    }
}
