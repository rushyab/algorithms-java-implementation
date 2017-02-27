package rushyab.algorithms.sorting;

import java.util.Random;

/**
 * Quick3way sort is a modified version of QuickSort which is more efficient
 * for an array with more number of equal keys.
 * For example, {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2}
 * The sort function partitions a[] in three parts
 * a) a[lo..lt-1] contains all elements smaller than pivot
 * b) a[lt..gt] contains all occurrences of pivot
 * c) a[gt+1..hi] contains all elements greater than pivot
 *
 * Algorithm Paradigm: Divide and conquer.
 * Space: In-place.
 * Stable: False.
 *
 * Average case = O(n*log n), Worst case = O(n^2), Best case = O(n) [three-way partition and equal keys]
 * worst case space complexity: O(n) (naive), O(log n) (Sedgewick 1978)
 */

public class Quick3way {

    // This class should not be instantiated.
    private Quick3way() {
    }

    private static Random random;

    public static <T extends Comparable<T>> T[] sort(T[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
        return a;
    }

    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo, gt = hi;
        T v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);

            if (cmp < 0) swap(a, lt++, i++);
            if (cmp > 0) swap(a, i, gt--);
            if (cmp == 0) i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    // shuffle the elements of array a
    private static <T> void shuffle(T[] a) {

        if (random == null) random = new Random();
        int count = a.length;
        for (int i = count; i > 1; i--) {
            swap(a, i-1, random.nextInt(i));
        }
    }

    private static <T> void swap(T[] a, int index1, int index2) {
        T value = a[index1];
        a[index1] = a[index2];
        a[index2] = value;
    }
}
