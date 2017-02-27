package rushyab.algorithms.data_structures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void testArrayImplementation() {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();

        for (int i = 1; i <= 5; i++) stack.push(i);

        assert(stack.size() == 5);

        int poppedElement = stack.pop();
        assertEquals(5, poppedElement);

        assert(stack.peek() == 4);
    }

    @Test
    public void testLinkedListImplementation() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("first");
        stack.push("last");

        assertEquals("last", stack.peek());

        stack.pop();
        stack.pop();

        assertEquals(true, stack.isEmpty());
    }
}