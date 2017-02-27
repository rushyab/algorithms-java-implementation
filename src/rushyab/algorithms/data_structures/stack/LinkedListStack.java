package rushyab.algorithms.data_structures.stack;

import java.util.EmptyStackException;

/**
 * A stack is a last in, first out (LIFO) abstract data type and linear
 * data structure. A stack can have any abstract data type as an element, but is
 * characterized by two fundamental operations, called push and pop. The push
 * operation adds a new item to the top of the stack, or initializes the stack
 * if it is empty. If the stack is full and does not contain enough space to
 * accept the given item, the stack is then considered to be in an overflow
 * state. The pop operation removes an item from the top of the stack.
 *
 * http://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */

public class LinkedListStack<T> {

    // Node class
    private class stackNode<T> {
        private T data;
        private stackNode<T> next;

        private stackNode(T data) {
            this.data = data;
        }
    }

    private stackNode<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        stackNode<T> t = new stackNode<>(data);
        t.next = top;
        top = t;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }
}