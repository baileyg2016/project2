/**
 * 
 * @author BaileySpell and Adam Tapp
 *
 * @param <T>
 *            Generic type
 */
public class ReviewerList<T> {
    /**
     * Node class for this reviewer list
     * 
     * @author BaileySpell & Adam Tapp
     *
     * @param <E>
     *            The generic type for the class
     */
    static class Node<E> {
        /**
         * Next node in the list
         */
        Node<E> next;
        /**
         * list object for the ratings
         */
        public RDLList<E> list;
        /**
         * Name of the reviewer
         */
        String name;


        /**
         * Constructor for the node
         * 
         * @param name
         *            name of the reviewer
         */
        Node(String name) {
            next = null;
            this.name = name;
        }


        /**
         * Sets the next node in the list
         * 
         * @param name
         *            The name of the reviewer for the next node
         */
        void setNext(String name) {
            this.next = new Node<E>(name);
        }
    }

    /**
     * head of list
     */
    private Node<T> head;
    /**
     * tail of the list
     */
    private Node<T> tail;
    /**
     * Total number of nodes in the list
     */
    private int numNodes;


    /**
     * The default constructor for the list
     */
    public ReviewerList() {
        head = null;
        tail = head;
    }


    /**
     * The constructor that takes in a name
     * 
     * @param name
     *            Name of the reviewer
     */
    public ReviewerList(String name) {
        head = new Node<T>(name);
        tail = head;
    }


    /**
     * Inserting at the tail of the list
     * 
     * @param name
     *            name of the reviewer to add
     */
    public void insert(String name) {
        if (head == null) {
            head = new Node<T>(name);
            tail = head;
            numNodes++;
            return;
        }

        tail.setNext(name);
        tail = tail.next;
        numNodes++;
    }


    /**
     * deleting the name from the list
     * 
     * @param name
     *            the name to delete
     */
    public void delete(String name) {
        if (numNodes == 1) {
            tail = null;
            head = null;
            numNodes--;
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;

        while (curr != null && !curr.name.equals(name)) {
            prev = curr;
            curr = curr.next;

        }
        if (curr == null) {
            return;
        }
        prev.next = curr.next;
        numNodes--;
    }


    /**
     * Print all the contents in the list
     */
    public void printList() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.name);
            curr = curr.next;
        }
    }


    /**
     * 
     * @return
     *         The count of the nodes in the list
     */
    public int getCount() {
        return numNodes;
    }
}
