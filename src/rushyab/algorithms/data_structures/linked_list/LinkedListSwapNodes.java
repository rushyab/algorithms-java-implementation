package rushyab.algorithms.data_structures.linked_list;

/* This program swaps the Nodes of the linked list rather than swapping the data from the nodes */

public class LinkedListSwapNodes {

    // Node class
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; next = null; }  // constructor
    }

    private Node head; // head node

    /* function to swap nodes */
    public void swapNodes(int x, int y) {

        // if x and y are same, do nothing
        if (x == y) return;

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // if x or y is not present in the list, do nothing
        if (currX == null || currY == null) return;

        // if x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y head
            head = currY;

        // if y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x head
            head = currX;

        // swap node pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    /* adds a new node at the beginning of the linked list */
    public void push(int new_data) {

        // create new node and allocate the data
        Node new_node = new Node(new_data);

        // point the new node to the head node
        new_node.next = head;

        // make the new node as head node
        head = new_node;
    }

    /* prints the contents of linked list */
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListSwapNodes llist = new LinkedListSwapNodes();

        llist.push(4);
        llist.push(2);
        llist.push(3);
        llist.push(1);

        System.out.println("Linked List before swapping Nodes: ");
        llist.printList(llist.head);

        llist.swapNodes(2, 3);

        System.out.println("\nLinked List after swapping Nodes: ");
        llist.printList(llist.head);
    }
}
