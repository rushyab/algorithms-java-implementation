package rushyab.algorithms.data_structures.queue;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ResizingArrayQueue<T> {
    private T[] q;     // queue elements
    private int n;     // number of elements
    private int first; // index of first element of queue
    private int last;  // index of next available slot

    public ResizingArrayQueue() {
        q = (T[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }

    // resize the underlying array
    private void resize(int capacity) {
        assert capacity >= n;

        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(first + i) % q.length];
        }

        q = temp;
        first = 0;
        last = n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void add(T item) {
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(2 * q.length);

        q[last] = item;
        last = (last + 1 ) % q.length;  // wrap around
        n++;
    }

    public T remove() {
        if (isEmpty()) throw new NoSuchElementException("ResizingArrayQueue Underflow");
        T item = q[first];
        q[first] = null;                // to avoid loitering
        n--;
        first = (first + 1) % q.length; // wrap around

        // shrink size, if necessary
        if (n > 0 && n == q.length/4) resize(q.length / 2);

        return item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("ResizingArrayQueue Underflow");

        return q[first];
    }

    public int size() { return n; }

    public String toString() {
        if (isEmpty()) throw new NoSuchElementException("ResizingArrayQueue Underflow");

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = first; i < last; i++) {
            sb.append(q[i].toString());
            if (i < last-1) {
                sb.append(", ");
            }
        }
        sb.append(']');

        return sb.toString();
    }
}