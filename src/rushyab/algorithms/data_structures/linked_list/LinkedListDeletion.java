package rushyab.algorithms.data_structures.linked_list;

public class LinkedListDeletion {
    private Node head;
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    /* Given a key, deletes the first occurrence of key in linked list */
    public void deleteNode(int key) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /* delete a node at a given position */
    public void deleteNodePos(int position) {
        // check if list is empty
        if (head == null)  return;

        Node temp = head;

        // If head needs to be removed

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; i < position-1 && temp != null; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next;
    }

    /* Inserts a new Node at front of the list. */
    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void printList(Node head) {
        Node tnode = head;
        while (tnode !=null) {
            System.out.print(tnode.data + "\t");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        LinkedListDeletion llist = new LinkedListDeletion();

        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);

        System.out.println("Created Linked list is:");
        llist.printList(llist.head);

        llist.deleteNode(3);

        System.out.println("\nLinked List after Deletion of 3 ");
        llist.printList(llist.head);

        llist.deleteNodePos(1);

        System.out.println("\nLinked List after Deletion at position 1: ");
        llist.printList(llist.head);
    }
}
