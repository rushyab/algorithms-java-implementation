package rushyab.algorithms.data_structures.linked_list;

// program to find the length of a Linked List
public class LinkedListLength {

    private Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; } // constructor
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }

        new_node.next = head;
        head = new_node;
    }

    // iterative solution
    public int getCount() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        return count;
    }

    // recursive solution
    public int getCountRec(Node node) {

        // Base case
        if (node == null)
            return 0;

        // count is this node plus the rest of the list
        return 1 + getCountRec(node.next);
    }

    public static void main(String[] args) {
        LinkedListLength llist = new LinkedListLength();

        llist.push(1);
        llist.push(3);
        llist.push(5);
        llist.push(7);

        System.out.println("The length of the list using iteration is: " + llist.getCount());

        System.out.println("The length of the list using recursion is: " +llist.getCountRec(llist.head));
    }
}
