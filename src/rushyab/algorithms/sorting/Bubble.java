package rushyab.algorithms.sorting;

/**
 * Bubble sort is a simple sorting algorithm that works by repeatedly stepping
 * through the list to be sorted, comparing each pair of adjacent items and
 * swapping them if they are in the wrong order. The pass through the list is
 * repeated until no swaps are needed, which indicates that the list is sorted.
 *
 * Family: Exchanging. 
 * Space: In-place. 
 * Stable: True.
 *
 * Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 *
 * http://en.wikipedia.org/wiki/Bubble_sort
 */

 public class Bubble {

    // This class should not be instantiated.
    private Bubble() { }

    public static <T extends Comparable<T>> T[] sort(T[] a) {
        boolean swapped = true;
        int n = a.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i].compareTo(a[i - 1]) < 0) {
                    swap(a, i, i-1);
                    swapped = true;
                }
            }
            n--;
        }
        return a;
    }

    private static <T extends Comparable<T>> void swap(T[] a, int index1, int index2) {
        T value = a[index1];
        a[index1] = a[index2];
        a[index2] = value;
    }
}
