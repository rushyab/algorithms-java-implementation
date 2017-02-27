package rushyab.algorithms.sorting;

/**
 * Merge sort is an efficient, general-purpose, comparison-based sorting algorithm.
 * Most implementations produce a stable sort, which means that the implementation
 * preserves the input order of equal elements in the sorted output.
 *
 * Algorithm Paradigm: Divide and conquer
 * Space: Not In-place.
 * Stable: True.
 *
 * Average case = O(n*log n) Worst case = O(n*log n) Best case = O(n*log n)
 * Auxiliary Space: O(n)
 *
 * http://en.wikipedia.org/wiki/Merge_sort
 */

public class Merge {

    // This class should not be instantiated.
    private Merge() { }

    private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++)   aux[k] = a[k];

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                       a[k] = aux[j++];
            else if (j > hi)                        a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0)  a[k] = aux[j++];
            else                                    a[k] = aux[i++];
        }
    }

    private static <T extends Comparable<T>> void sort(T[] a, T[] aux, int lo, int hi) {
        // base case
        if (hi <= lo)   return;

        int mid = lo + (hi - lo)/2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] sort(T[] a) {
        T[] aux = (T[]) new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        return a;
    }
}
