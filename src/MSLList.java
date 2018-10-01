
/**
 * 
 * @author Adam Tapp and Bailey Spell
 * @version Milestone 2
 * @param <Integer>
 */
public class MSLList {

    /**
     * Represents the list that will serve as the Movie list
     * and Reviewer list that is in the sparse matrix
     */

    public class Node {
        /**
         * 1. Name of this node
         * 2. Contains a MDLList
         * 3. Maybe a number
         */
        /**
         * nameition of this node
         */
        public String name;
        /**
         * list of movies
         */
        public MDLList<Integer> list;

        /**
         * the next node in the list
         */
        public Node next;


        /**
         * Node constructor
         * 
         * @param name
         *            nameition of the node
         * @param list
         *            list stored in the node
         * @param next
         *            the next node in the list
         */
        public Node(String name, MDLList<Integer> list, Node next) {
            this.name = name;
            this.list = list;
            this.next = next;
        }


        public Node(String name, MDLList<Integer> list) {
            this.name = name;
            this.list = list;
            this.next = null;
        }


        public Node(String name) {
            next = null;
            this.name = name;
            list = new MDLList<Integer>();
        }


        /**
         * gets the nameition
         * 
         * @return String
         *         the nameition of this node
         */
        public String getName() {
            return name;
        }


        /**
         * Sets the list contained in this
         * 
         * @return MDLList<Integer>
         *         list contained in this node
         */
        public MDLList<Integer> getList() {
            return list;
        }


        /**
         * Sets the next node in the list
         * 
         * @param node
         *            the new next node
         */
        public void setNext(Node node) {
            this.next = node;
        }


        /**
         * Gets the next node
         * 
         * @return Node
         *         returns the next node
         */
        public Node getNext() {
            return next;
        }

    }

    /**
     * Head of the list
     */
    public Node head;

    /**
     * Tail of the list
     */
    public Node tail;

    /**
     * Size of the list
     */
    public int size;


    // Rows
    public MSLList() {
        head = null;
        tail = head;
        size = 0;
    }


    /**
     * Adding a node to the list
     * This is done when the name does not already exist
     * in the movie list
     * 
     * @param name
     *            the name of the movie
     */
    public Node add(String name) {
        MDLList<Integer> mList = new MDLList<>();
        if (isEmpty()) {
            head = new Node(name, mList);
            tail = head;
            size++;
            return (Node)tail;
        }

        if (contains(name) != null) {
            return contains(name);
        }

        Node node = new Node(name, mList);
        tail.setNext(node);
        tail = tail.next;

        size++;
        return tail;
    }


    /**
     * Removing a node from a given nameition
     */
    public Node remove(String name) {
        Node n = head;
        while (!(n.getNext().equals(tail))) {
            if (n.getNext().getName().equals(name)) {
                Node temp = n.getNext();
                n.setNext(temp.getNext());
                temp.setNext(null);
                size--;
                return temp;
            }
            n = n.getNext();
        }
        return null;
    }


    /**
     * Contains method
     * 
     * @return the node
     *         return true if the name is in the list
     */
    public Node contains(String name) {
        Node n = head;
        while (n != null) {
            if (n.getName().equals(name)) {
                return n;
            }
            n = n.getNext();
        }
        return null;

    }


    /**
     * Status on if the list is empty
     * 
     * @return boolean
     *         returns if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * A string representation of the nodes in the list
     * 
     * @return String
     *         a string representation of the nodes and their nameitions in the
     *         list
     */
    public String toString() {
        Node n = head.getNext();
        String s = "{";
        while (!(n.equals(tail))) {
            s += n.getName() + " ";
            if (n.getNext() != tail) {
                s += ", ";
            }
            n = n.getNext();
        }
        s += "}";
        return s;
    }

}
