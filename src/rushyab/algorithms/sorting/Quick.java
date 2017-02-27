package rushyab.algorithms.sorting;

import java.util.Random;

/**
 * QuickSort is a sorting algorithm which, on average, makes O(n*log n) comparisons to sort
 * n items. In the worst case, it makes O(n^2) comparisons, though this behavior is
 * rare. QuickSort is often faster in practice than other algorithms.
 *
 * Algorithm Paradigm: Divide and conquer.
 * Space: In-place.
 * Stable: False.
 *
 * Average case = O(n*log n), Worst case = O(n^2), Best case = O(n*log n) (simple partition)
 * worst case space complexity: O(n) (naive), O(log n) (Sedgewick 1978)
 *
 * http://en.wikipedia.org/wiki/Quick_sort
 */

public class Quick {

    // This class should not be instantiated.
    private Quick() { }

    private static Random random;

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static <T extends Comparable<T>> T[] sort(T[] a) {
        shuffle(a);
        sort(a, 0, a.length-1);
        return a;
    }

    // quick_sort the sub_array from a[lo] to a[hi]
    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // partition the sub_array a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        T v = a[lo];
        while (true) {

            while (a[++i].compareTo(v) < 0)
                if (i == hi) break;

            while (v.compareTo(a[--j]) < 0)
                if (j == lo) break;

            if (i >= j) break;

            swap(a, i, j);
        }

        swap(a, lo, j);
        return j;
    }

    // shuffle the elements of array a.
    private static <T> void shuffle(T[] a) {

        if (random == null) random = new Random();
        int count = a.length;
        for (int i = count; i > 1; i--) {
            swap(a, i - 1, random.nextInt(i));
        }
    }

    private static <T> void swap(T[] a, int index1, int index2) {
        T value = a[index1];
        a[index1] = a[index2];
        a[index2] = value;
    }
}
