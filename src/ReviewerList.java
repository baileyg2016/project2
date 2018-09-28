
public class ReviewerList<T> {
	private Node<T> head;
	private Node<T> tail;
    
	
	
	private int numNodes;
	private int count;

	static class Node<E> {
		Node<E> next;
		public RDLList<E> list;
		int pos;

		Node(int pos) {
			next = null;
			this.pos = pos;
		}

		void setNext(int count) {
			this.next = new Node<E>(count);
		}
	}

	public ReviewerList() {
		head = null;
		tail = head;
		count = 0;
	}

	public ReviewerList(int pos) {
		head = new Node<T>(pos);
		tail = head;
		count = 0;
	}

	public int insert() {
		count++;
		if (head == null) {
			head = new Node<T>(count);
			tail = head;
			numNodes++;
			return count;
		}

		tail.setNext(count);
		tail = tail.next;
		numNodes++;
		return count;
	}

	public void delete(int pos) {
		if (numNodes == 1) {
			tail = null;
			head = null;
			numNodes--;
			return;
		}

		Node<T> curr = head;
		Node<T> prev = null;

		while (curr != null && curr.pos != pos) {
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
			System.out.println(curr.pos);
			curr = curr.next;
		}
	}
	
	public int getCount() {
		return numNodes;
	}
}
