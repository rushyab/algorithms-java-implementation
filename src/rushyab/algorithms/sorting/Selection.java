package rushyab.algorithms.sorting;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 * (considering ascending order) from unsorted part and putting it at the beginning.
 *
 * Family: Exchanging
 * Sorting In Place: Yes
 * Stable: Yes
 *
 * Average case = O(n^2) Worst case = O(n^2) Best case = O(n^2)
 * Auxiliary Space: O(1)
 *
 * uses: selection sort never makes more than O(n) swaps
 * and can be useful when memory write is a costly operation.
 */

public class Selection {

    // This class should not be instantiated.
    private Selection() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * @return a sorted array
     */
    public static <T extends Comparable<T>> T[] sort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(a[j].compareTo(a[min]) < 0)  min = j;
            }
            if (min !=  i) {
                swap(a, i, min);
            }
        }
        return a;
    }

    private static  <T extends Comparable<T>> void swap(T[] a, int index1, int index2) {
        T value = a[index1];
        a[index1] = a[index2];
        a[index2] = value;
    }
}
