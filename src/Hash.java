/**
 * Stub for hash table class
 *
 * @author CS3114 staff
 * @version August 2018
 */

public class Hash<T> {

    /**
     * The size of the table
     */
    private int hashTableSize;

    /**
     * The amount of entries in the table
     */
    private int hashTableCount;


    /**
     * Create a new Hash object.
     * 
     */
    public Hash(int size) {
        // Nothing here yet
        this.hashTableCount = 0;
        this.hashTableSize = size;
        
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
}
