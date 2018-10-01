//import MSLList.Node;

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
         * The number of records added thus far
         */
        private int count;
        
        /**
         * Constructor for the node
         * 
         * @param name
         *            name of the reviewer
         * @param count
         *            the number of records added thus far
         */
        Node(String name, int count, RDLList<E> list) {
            next = null;
            this.name = name;
            this.count = count;
            this.list = list;
        }


        /**
         * Sets the next node in the list
         * 
         * @param name
         *            The name of the reviewer for the next node
         * @param count
         *            The number of records added thus far
         */
        void setNext(String name, int count, RDLList<E> list) {
            this.next = new Node<E>(name, count, list);
        }
        
        /**
         * Gets the next node
         * @return Node
         *          next node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the list contained in this
         * 
         * @return MDLList<Integer>
         *         list contained in this node
         */
        public RDLList<E> getList() {
            return list;
        }
        
        /**
         * Gets count
         * @return int
         *          count
         */
        public int getCount() {
            return count;
        }
        
        /**
         * Sets count
         * @param count
         *          the count
         */
        public void setCount(int count) {
            this.count = count;
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
     * Total number of inserts made on the list
     */
    private int count; 

    /**
     * The default constructor for the list
     */
    public ReviewerList() {
        head = null;
        tail = head;
        count = 0;
    }


    /**
     * The constructor that takes in a name
     * 
     * @param name
     *            Name of the reviewer
     */
    public ReviewerList(String name) {
        count = 0;
        head = new Node<T>(name, count, null);
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
            head = new Node<T>(name, count, new RDLList<T>());
            tail = head;
            count++;
            numNodes++;
            return;
        }

        tail.setNext(name, count, new RDLList<T>());
        
        tail = tail.next;
        count++;
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
        if (prev == null) {
            head = curr.next;
            numNodes--;
            return;
        }
        prev.next = curr.next;
        numNodes--;
    }


    /**
     * Contains method
     * 
     * @param name
     *            the name of the node that we are searching for
     * @return Node<Integer>
     *         return true if the name is in the list
     */
    public Node<T> contains(String name) {
        if (isEmpty()) {
            return null;
        }
        Node<T> n = head;
        if (n == tail) {
            return (n.name.equals(name)) ? n: null;
        }
        while (n != null) {
            if (n.name.equals(name)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }


    /**
     * Finds a list in a node
     * 
     * @param name
     *            the name of the list we need
     * @return RDLList<Integer>
     *         the list we need
     */
    public RDLList<T> getList(String name) {
        Node<T> n = contains(name);
        return (n == null) ? null : n.getList();
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
     * Print all the contents in the list
     */
    public void printListAndCount() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.name + ": " + curr.getCount());
            curr = curr.next;
        }
    }
    
    /**
     * empty method
     * @return boolean
     *          true if the size is 0
     */
    public boolean isEmpty() {
        return numNodes == 0;        
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
