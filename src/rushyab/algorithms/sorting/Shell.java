package rushyab.algorithms.sorting;

/**
 * ShellSort, also known as Shell sort or Shell's method, is an in-place
 * comparison sort. It generalizes an exchanging sort, such as insertion or
 * bubble sort, by starting the comparison and exchange of elements with
 * elements that are far apart before finishing with neighboring elements.
 * Starting with far apart elements can move some out-of-place elements into
 * position faster than a simple nearest neighbor exchange.
 * Family: Exchanging.
 * Space: In-place. Stable: False.
 *
 * Average case = depends on the gap(Increments), Worst case = O(n*log^2 n), Best case = O(n)
 *
 * http://en.wikipedia.org/wiki/Shell_sort
 *
 * Uses increment sequence proposed by Sedgewick and Incerpi.
 */

public class Shell {

    // This class should not be instantiated.
    private Shell() { }

    public static <T extends Comparable<T>> T[] sort(T[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n/3) h = 3*h - 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j-h]) < 0; j-=h) {
                    swap(a, j, j-h);
                }
            }
            h = h/3;
        }
        return a;
    }

    private static <T extends Comparable<T>> void swap(T[] a, int index1, int index2) {
        T value = a[index1];
        a[index1] = a[index2];
        a[index2] = value;
    }
}
