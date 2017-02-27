package rushyab.algorithms.data_structures.linked_list;

public class LinkedListInsertion {

    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }  // constructor
    }

    private Node head; // head node

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

         /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

         /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is
      defined inside LinkedListInsertion class shown above */
    public void append(int new_data) {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the
              new node as head */
        if (head == null) {
            head = new_node;
            return;
        }

         /* 5. This new node is going to be the last node, so
              make next of it as null */
         new_node.next = null;

          /* 6. Else traverse till the last node */
          Node last = head;
          while (last.next != null)
              last = last.next;

           /* 6. Change the next of last node */
           last.next = new_node;
    }

    /* This function prints contents of linked list starting from
     the given node */
    public void printList(Node head) {
        Node tnode = head;
        while(tnode != null) {
            System.out.print(tnode.data+"\t");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        LinkedListInsertion llist = new LinkedListInsertion();

        // Insert 6. list becomes 6-->null
        llist.append(6);

        /* Insert 7 at the beginning. Now the list becomes,
           7-->6-->null */
        llist.push(7);

        /* Insert 1 at the beginning. Now the list becomes,
           1-->7-->6-->null */
        llist.push(1);

        /* Insert 4 at the end. Now the list becomes,
           1-->7-->6-->4-->null */
        llist.append(4);

        /* Insert 8 between 7 and 6. Now the list becomes,
           1-->7-->8-->6-->4-->null */
        llist.insertAfter(llist.head.next, 8);

        System.out.println("Created Linked List is: ");
        llist.printList(llist.head);
    }
}
