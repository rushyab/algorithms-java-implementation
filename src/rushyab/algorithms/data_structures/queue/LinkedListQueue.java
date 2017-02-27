package rushyab.algorithms.data_structures.queue;

import java.util.NoSuchElementException;

/**
 * A queue is a particular kind of abstract data type or collection in
 * which the entities in the collection are kept in order and the principal (or
 * only) operations on the collection are the addition of entities to the rear
 * terminal position and removal of entities from the front terminal position.
 * This makes the queue a First-In-First-Out (FIFO) data structure. In a FIFO
 * data structure, the first element added to the queue will be the first one to
 * be removed.
 *
 * http://en.wikipedia.org/wiki/Queue_(abstract_data_type)
 */

public class LinkedListQueue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        private QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public boolean isEmpty() { return first == null; }

    public void add(T data) {
        QueueNode<T> t = new QueueNode<>(data);

        if (last != null) {
            last.next = t;
        }
        last = t;

        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (isEmpty()) throw new NoSuchElementException();

        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();

        return first.data;
    }
}
