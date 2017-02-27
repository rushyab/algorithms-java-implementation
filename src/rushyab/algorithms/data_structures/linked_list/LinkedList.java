package rushyab.algorithms.data_structures.linked_list;

public class LinkedList {

    private Node head; // head of the list

    /* LinkedListDeletion Node. This inner class is made static
      so that main() can access it */
    static class Node {
        int data;
        Node next;

        Node(int d) { data = d; next = null; } // constructor
    }
	
	// function to traverse the list
	public void printList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "\t");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        // Empty list is created
        LinkedList llist = new LinkedList();


        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        /* Three nodes have been allocated  dynamically(on heap memory).
          We have references to these three blocks as first,
          second and third

          llist.head        second              third
             |                |                  |
             |                |                  |
         +----+------+     +----+------+     +----+------+
         | 1  | null |     | 2  | null |     |  3 | null |
         +----+------+     +----+------+     +----+------+ */

        llist.head.next = second; // Link first node with the second node

        /*  Now next of first Node refers to second.  So they
            both are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  | null |     |  3 | null |
        +----+------+     +----+------+     +----+------+ */

        second.next = third; // Link second node with the third node

        /*  Now next of second Node refers to third.  So all three
            nodes are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  |  o-------->|  3 | null |
        +----+------+     +----+------+     +----+------+ */
		
		System.out.println("The contents of the list are: ");
		llist.printList(llist.head);
    }
}
