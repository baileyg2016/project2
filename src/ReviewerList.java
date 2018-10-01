/**
 * 
 * @author BaileySpell and Adam Tapp
 *
 * @param
 * Generic
 *            type
 */
public class ReviewerList {
    /**
     * Node class for this reviewer list
     * 
     * @author BaileySpell & Adam Tapp
     *
     * @param <E>
     *            The generic type for the class
     */
    static class Node {
        /**
         * Next node in the list
         */
        Node next;
        /**
         * list object for the ratings
         */
        public RDLList<Integer> list;
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
            list = new RDLList<Integer>();
        }


        /**
         * Sets the next node in the list
         * 
         * @param name
         *            The name of the reviewer for the next node
         */
        void setNext(String name) {
            this.next = new Node(name);
        }


        String getName() {
            return name;
        }
    }

    /**
     * head of list
     */
    private Node head;
    /**
     * tail of the list
     */
    private Node tail;
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
        head = new Node(name);
        tail = head;
    }


    /**
     * Inserting at the tail of the list
     * 
     * @param name
     *            name of the reviewer to add
     */
    // @SuppressWarnings("unchecked")
    public Node insert(String name) {
        if (head == null) {
            head = new Node(name);
            tail = head;
            numNodes++;
            return (Node)tail;
        }

        if (contains(name) != null) {
            return contains(name);
        }

        tail.setNext(name);
        tail = tail.next;
        numNodes++;
        return (Node)tail;
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

        Node curr = head;
        Node prev = null;

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
        Node curr = head;
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


    /**
     * 
     * @return
     *         The tail of the nodes in the list
     */
    public Node getTail() {
        return tail;
    }


    public Node contains(String reviewer) {
        Node curr = head;
        while (curr != null) {
            if (curr.name.equals(reviewer)) {
                return curr;
            }
            curr = curr.next;
        }
        return curr;
    }
}
