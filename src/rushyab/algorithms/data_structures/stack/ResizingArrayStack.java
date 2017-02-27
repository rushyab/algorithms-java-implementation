package rushyab.algorithms.data_structures.stack;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class ResizingArrayStack<T> {

    private T[] s;   // stack elements
    private int n;   // number of elements on stack

    public ResizingArrayStack() {
        // start with array of size 2
        s = (T[]) new Object[2];
        n = 0;
    }

    // Function to resize the underlying array
    private void resize(int capacity) {
        assert capacity >= n;

        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = s[i];
        }
        s = temp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(T value) {
        if (n == s.length) resize(2 * s.length);
        s[n++] = value;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = s[n-1];
        s[n-1] = null;      // to avoid loitering
        n--;

        // shrink size of say if necessary
        // if only 1/4th of the array is filled, then shrink the size to half
        if (n > 0 && n == s.length/4) resize(s.length / 2);
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return s[n-1];
    }

    public int size() { return n; }

    public String toString() {
        if (isEmpty()) throw new EmptyStackException();

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < n; i++) {
            sb.append(s[i].toString());
            if (i < n-1) sb.append(", ");
        }
        sb.append(']');

        return sb.toString();
    }
}
