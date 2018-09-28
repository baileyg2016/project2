/**
 * 
 * @author Adam Tapp and Bailey Spell
 * @version Milestone 2
 * @param <T>
 */
public class MSLList<T> {

    /**
     * Represents the list that will serve as the Movie list
     * and Reviewer list that is in the sparse matrix
     */

    public class Node<E> {
        /**
         * 1. Next position
         * 2. Contains a MDLList
         * 3. Maybe a number
         */
        /**
         * Position of this node
         */
        public int pos;
        /**
         * list of movies
         */
        public MDLList<E> list;

        /**
         * the next node in the list
         */
        public Node<E> next;


        /**
         * Node constructor
         * 
         * @param pos
         *            position of the node
         * @param list
         *            list stored in the node
         * @param next
         *            the next node in the list
         */
        public Node(int pos, MDLList<E> list, Node<E> next) {
            this.pos = pos;
            this.list = list;
            this.next = next;
        }


        /**
         * gets the position
         * 
         * @return int
         *         the position of this node
         */
        public int getPos() {
            return pos;
        }


        /**
         * Sets the list contained in this
         * 
         * @return MDLList<T>
         *         list contained in this node
         */
        public MDLList<E> getList() {
            return list;
        }


        /**
         * Sets the next node in the list
         * 
         * @param node
         *            the new next node
         */
        public void setNext(Node<E> node) {
            this.next = node;
        }


        /**
         * Gets the next node
         * 
         * @return Node<T>
         *         returns the next node
         */
        public Node<E> getNext() {
            return next;
        }

    }

    /**
     * Head of the list
     */
    public Node<T> head;

    /**
     * Tail of the list
     */
    public Node<T> tail;

    /**
     * Size of the list
     */
    public int size;


    // Rows
    public MSLList() {
        head = new Node<T>(-1, null, tail);
        tail = new Node<T>(-1, null, head);
        size = 0;
    }


    /**
     * Adding a node to the list
     */
    public void add(Node<T> node) {
        Node<T> aNode = tail.getNext();
        aNode.setNext(node);
        node.setNext(tail);
        tail.setNext(node);
        size++;
    }


    /**
     * Removing a node from a given position
     */
    public Node<T> remove(int pos) {
        Node<T> n = head;
        while (!(n.getNext().equals(tail))) {
            if (n.getNext().getPos() == pos) {
                Node<T> temp = n.getNext();
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
     * @return String
     *         a string representation of the nodes and their positions in the
     *         list
     */
    public String toString() {
        Node<T> n = head.getNext();
        String s = "{";
        while (!(n.equals(tail))) {
            s += n.getPos() + " ";
            if (n.getNext() != tail) {
                s += ", ";
            }
            n = n.getNext();
        }
        s += "}";
        return s;
    }

}
