
/**
 * 
 * @author Adam Tapp and Bailey Spell
 * @version Milestone 2
 */
public class MSLList {

    /**
     * Represents the list that will serve as the Movie list
     * and Reviewer list that is in the sparse matrix
     */
    public class Node {
        /**
         * Name of this node
         */
        public String name;
        /**
         * list of movies
         * 
         * @param Integer
         *            holds an integer value
         */
        public MDLList<Integer> list;

        /**
         * the next node in the list
         */
        public Node next;

        /**
         * The number of entries added thus far
         */
        public int count;


        /**
         * Node constructor
         * 
         * @param name
         *            name of the node
         * @param list
         *            list stored in the node
         * @param next
         *            the next node in the list
         * @param count
         *            the number of entries added thus far
         */
        public Node(String name, MDLList<Integer> list, Node next, int count) {
            this.name = name;
            this.list = list;
            this.next = next;
            this.count = count;
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
         * gets the name
         * 
         * @return String
         *         the name of this node
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
         * @param count
         *            the count
         */
        public void setCount(int count) {
            this.count = count;
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


    /**
     * Rows of the singly linked list
     */
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

//        if (contains(name) != null) {
//            return contains(name);
//        }

        Node node = new Node(name, mList);
        tail.setNext(node);
        tail = tail.next;

        size++;
        return tail;
    }


    /**
     * Removing a node from a given name
     * 
     * @param name
     *            name of the node that needs to be removed
     * @return Node
     *         the node that was removed
     */
    public Node remove(String name) {
        Node n = head;
        Node prev = head;
        while (n != null) {
            if (n.getName().equals(name)) {
                Node next = n.getNext();
                n.setNext(null);
                if (n == head) {
                    head = next;
                }
                prev.setNext(n.getNext());      

                size--;
                return n;
            }
            prev = n;
            n = n.getNext();
        }
        return null;
    }


    /**
     * Contains method
     * 
     * @param name
     *            the name of the node that we are searching for
     * @return Node
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
     * Finds a list in a node
     * 
     * @param name
     *            the name of the list we need
     * @return MDLList<Integer>
     *         the list we need
     */
    public MDLList<Integer> getList(String name) {
        Node n = contains(name);
        return (n == null) ? null : n.getList();
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
     *         a string representation of the nodes and their name in the
     *         list
     */
    public String toString() {
        Node n = head;
        String s = "{ ";
        while (n != null) {
            s += n.getName() + " ";
            if (n != tail) {
                s += ", ";
            }
            n = n.getNext();
        }
        s += "}";
        return s;
    }


    /**
     * Printing the name of the movie and the reviewer and score for each review
     * of that movie
     * 
     * @return String
     *         String of movies, reviewer counts and the scores they gave
     */
    public String printListAndReviews() {
        Node n = head;
        String s = "";
        while (n != null) {
            s += n.getName() + ": ";
            MDLList<Integer> list = n.getList();
            s += list.getCountAndScore();
            if (n != tail) {
                s += "\n";
            }
            n = n.getNext();
        }
        // s += "}";
        return s;
    }

}
