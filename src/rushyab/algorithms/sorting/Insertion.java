package rushyab.algorithms.sorting;

/**
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 *
 * Algorithmic Paradigm: Incremental Approach
 * Sorting In Place: Yes
 * Stable: Yes
 * Online: Yes
 *
 * Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 * Auxiliary Space: O(1)
 *
 * Uses: Insertion sort is used when number of elements is small.
 * It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
 */

public class Insertion {

    // This class should not be instantiated.
    private Insertion() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * @return a sorted array
     */
    public static <T extends Comparable<T>> T[] sort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            T key = a[i];
            int j = i;
            while (j > 0 && key.compareTo(a[j-1]) < 0) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }
        return a;
    }
}
