// import MSLList.Node;

/**
 * 
 * @author BaileySpell and Adam Tapp
 * @version Milestone 2
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
     */
    static class Node {
        /**
         * Next node in the list
         */
        private Node next;
        /**
         * list object for the ratings
         */
        private RDLList<Integer> list;
        /**
         * Name of the reviewer
         */
        private String name;

        /**
         * The number of records added thus far
         */
        private int count;


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
         * Constructor for the node
         * 
         * @param nodeName
         *            name of the reviewer
         * @param nodeCount
         *            the number of records added thus far
         * @param rlist
         *            sets the double linked list for the node
         */
        Node(String nodeName, int nodeCount, RDLList<Integer> rlist) {
            next = null;
            this.name = nodeName;
            list = new RDLList<Integer>();
            this.count = nodeCount;
            this.list = rlist;
        }


        /**
         * Sets the next node in the list
         * 
         * @param nodeName
         *            The name of the reviewer for the next node
         * @param count
         *            The number of records added thus far
         * @param rlist
         *            sets the list for the node
         */
        void setNext(String nodeName, int nodeCount, RDLList<Integer> rlist) {
            this.next = new Node(nodeName, nodeCount, rlist);
        }


        /**
         * Gets the next node
         * 
         * @return Node
         *         next node
         */
        public Node getNext() {
            return next;
        }


        /**
         * Sets the list contained in this
         * 
         * @return MDLList<Integer>
         *         list contained in this node
         */
        public RDLList<Integer> getList() {
            return list;
        }


        /**
         * Gets count
         * 
         * @return int
         *         count
         */
        public int getCount() {
            return count;
        }


        /**
         * Sets count
         * 
         * @param name
         *            sets the next name
         */
        void setNext(String name) {
            this.next = new Node(name);
        }


        /**
         * 
         * @return
         *         the name of the node
         */
        String getName() {
            return name;
        }


        /**
         * Sets the count for the node
         * 
         * @param count
         *            The count for the node
         */
        public void setCount(int count) {
            this.count = count;
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
        head = new Node(name);
        count = 0;
        tail = head;

    }


    /**
     * Inserting at the tail of the list
     * 
     * @param name
     *            name of the reviewer to add
     * @return
     *         the tail of the list
     */
    public Node insert(String name) {
        if (head == null) {
            head = new Node(name);
            tail = head;

            head.setCount(count);
            count++;
            numNodes++;
            return (Node)tail;
        }

        tail.setNext(name, count, new RDLList<Integer>());

        tail = tail.next;

        tail.setCount(count);
        count++;
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

        if (curr != null && curr.name.equals(name)) {
            head = head.getNext();
            numNodes--;
            return;
        }

        while (curr != null && !curr.name.equals(name)) {
            prev = curr;
            curr = curr.getNext();

        }

        if (curr == null) {
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
    public Node contains(String name) {
        if (isEmpty()) {
            return null;
        }
        Node n = head;
        if (n == tail) {
            return (n.name.equals(name)) ? n : null;
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
    public RDLList<Integer> getList(String name) {
        Node n = contains(name);
        return (n == null) ? null : n.getList();
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
     * Print all the contents in the list
     */
    public void printListAndCount() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.name + ": " + curr.getCount());
            curr = curr.next;
        }
    }


    /**
     * empty method
     * 
     * @return boolean
     *         true if the size is 0
     */
    public boolean isEmpty() {
        return numNodes == 0;
    }


    /**
     * 
     * @return
     *         The count for the nodes in the list
     */
    public int getCount() {
        return numNodes;
    }


    /**
     * Gets the head
     * 
     * @return
     *         the head of the nodes
     */
    public Node getHead() {
        return head;
    }


    /**
     * 
     * @return
     *         The tail of the nodes in the list
     */
    public Node getTail() {
        return tail;
    }

}
