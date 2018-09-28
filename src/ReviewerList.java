
public class ReviewerList {
	private Node head;
	private Node tail;
	private int numNodes;
	private int count;

	static class Node {
		Node next;

		int pos;

		Node(int pos) {
			next = null;
			this.pos = pos;
		}

		void setNext(int count) {
			this.next = new Node(count);
		}
	}

	public ReviewerList() {
		head = null;
		tail = head;
		count = 0;
	}

	public ReviewerList(int pos) {
		head = new Node(pos);
		tail = head;
		count = 0;
	}

	public int insert() {
		count++;
		if (head == null) {
			head = new Node(count);
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

		Node curr = head;
		Node prev = null;

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
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.pos);
			curr = curr.next;
		}
	}
	
	public int getCount() {
		return numNodes;
	}
}
