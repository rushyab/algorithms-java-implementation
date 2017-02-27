package rushyab.algorithms.data_structures.linked_list;

public class LinkedListSearch {

    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    private Node head;

    // adds a new node at the beginning of the list
    public void push(int new_data) {
        Node new_node = new Node(new_data);

        new_node.next = head;
        head = new_node;
    }

    // Iterative solution
    public boolean search(Node head, int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) return  true;
            current = current.next;
        }
        return  false;
    }

    // Recursive solution
    public boolean searchRec(Node head, int x) {

        // Base case
        if (head == null) return false;

        // If key is present in current node, return true
        if (head.data == x) return true;

        // search the remaining list
        return searchRec(head.next, x);
    }

    public static void main(String[] args) {
        LinkedListSearch llist = new LinkedListSearch();

        // building list by pushing elements
        // 1->5->10->43->null
        llist.push(43);
        llist.push(10);
        llist.push(5);
        llist.push(1);

        if (llist.searchRec(llist.head, 43))
            System.out.println("Given element is present in the list");
        else
            System.out.println("Element not found");

    }
}
