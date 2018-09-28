
public class ReviewerList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int numNodes;


    static class Node<E> {
        Node<E> next;
        public RDLList<E> list;
        String name;


        Node(String name) {
            next = null;
            this.name = name;
        }


        void setNext(String name) {
            this.next = new Node<E>(name);
        }
    }


    public ReviewerList() {
        head = null;
        tail = head;
    }


    public ReviewerList(String pos) {
        head = new Node<T>(pos);
        tail = head;
    }


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


    public void printList() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.name);
            curr = curr.next;
        }
    }


    public int getCount() {
        return numNodes;
    }
}
