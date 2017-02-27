package rushyab.algorithms.data_structures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {
    @Test
    public void testArrayImplementation() {
        ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();

        for (int i = 1; i <= 5; i++) queue.add(i);

        assert(queue.size() == 5);

        int poppedElement = queue.remove();
        assertEquals(1, poppedElement);

        assert(queue.peek() == 2);
    }

    @Test
    public void testLinkedListImplementation() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        assertTrue(queue.isEmpty());

        for (int i = 1; i <= 5; i++) queue.add(i);

        assertFalse(queue.isEmpty());

        int poppedElement = queue.remove();
        assertEquals(1, poppedElement);

        assert(queue.peek() == 2);

    }
}