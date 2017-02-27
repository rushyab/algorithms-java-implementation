package rushyab.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class SortingTest {

    private static final Random RANDOM = new Random();
    private static final int SIZE = 10000;

    private static Integer[] unsorted = null;
    private static Integer[] sorted = null;
    private static Integer[] reverse = null;

    static {
        unsorted = new Integer[SIZE];
        int i = 0;
        while (i < unsorted.length) {
            int j = RANDOM.nextInt(unsorted.length * 10);
            unsorted[i++] = j;
        }

        sorted = new Integer[SIZE];
        for (i = 0; i < sorted.length; i++)
            sorted[i] = i;

        reverse = new Integer[SIZE];
        for (i = reverse.length-1; i >= 0; i--)
            reverse[i] = (SIZE - 1) - i;
    }

    @Test
    public void testSelection() {
        Integer[] result = Selection.sort(unsorted.clone());
        Assert.assertTrue("Selection sort unsorted error. result="+print(result), check(result));
        result = Selection.sort(sorted.clone());
        Assert.assertTrue("Selection sort sorted error. result="+print(result), check(result));
        result = Insertion.sort(reverse.clone());
        Assert.assertTrue("Selection sort reverse error. result="+print(result), check(result));
    }

    @Test
    public void testInsertion() {
        Integer[] result = Insertion.sort(unsorted.clone());
        Assert.assertTrue("Insertion sort unsorted error. result="+print(result), check(result));
        result = Insertion.sort(sorted.clone());
        Assert.assertTrue("Insertion sort sorted error. result="+print(result), check(result));
        result = Insertion.sort(reverse.clone());
        Assert.assertTrue("Insertion sort reverse error. result="+print(result), check(result));
    }

    @Test
    public void testShell() {
        Integer[] result = Shell.sort(unsorted.clone());
        Assert.assertTrue("Shell sort unsorted error. result="+print(result), check(result));
        result = Shell.sort(sorted.clone());
        Assert.assertTrue("Shell sort sorted error. result="+print(result), check(result));
        result = Shell.sort(reverse.clone());
        Assert.assertTrue("Shell sort reverse error. result="+print(result), check(result));
    }

    @Test
    public void testBubble() {
        Integer[] result = Bubble.sort(unsorted.clone());
        Assert.assertTrue("Bubble sort unsorted error. result="+print(result), check(result));
        result = Bubble.sort(sorted.clone());
        Assert.assertTrue("Bubble sort sorted error. result="+print(result), check(result));
        result = Bubble.sort(reverse.clone());
        Assert.assertTrue("Bubble sort reverse error. result="+print(result), check(result));
    }

    @Test
    public void testMerge() {
        Integer[] result = Merge.sort(unsorted.clone());
        Assert.assertTrue("Merge sort unsorted error. result="+print(result), check(result));
        result = Merge.sort(sorted.clone());
        Assert.assertTrue("Merge sort sorted error. result="+print(result), check(result));
        result = Merge.sort(reverse.clone());
        Assert.assertTrue("Merge sort reverse error. result="+print(result), check(result));
    }

    @Test
    public void testQuick() {
        Integer[] result = Quick.sort(unsorted.clone());
        Assert.assertTrue("Quick sort unsorted error. result="+print(result), check(result));
        result = Quick.sort(sorted.clone());
        Assert.assertTrue("Quick sort sorted error. result="+print(result), check(result));
        result = Quick.sort(reverse.clone());
        Assert.assertTrue("Quick sort reverse error. result="+print(result), check(result));
    }

    @Test
    public void testQuick3way() {
        Integer[] result = Quick3way.sort(unsorted.clone());
        Assert.assertTrue("Quick3way sort unsorted error. result="+print(result), check(result));
        result = Quick3way.sort(sorted.clone());
        Assert.assertTrue("Quick3way sort sorted error. result="+print(result), check(result));
        result = Quick3way.sort(reverse.clone());
        Assert.assertTrue("Quick3way sort reverse error. result="+print(result), check(result));
    }

    private static boolean check(Integer[] array) {
        for (int i = 1; i<array.length; i++) {
            if (array[i-1]>array[i])
                return false;
        }
        return true;
    }

    private static String print(Integer[] array) {
        return print(array, 0, array.length);
    }

    private static String print(Integer[] array, int start, int length) {
        final Integer[] clone = array.clone();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<length; i++) {
            int e = clone[start+i];
            builder.append(e+" ");
        }
        return builder.toString();
    }
}
