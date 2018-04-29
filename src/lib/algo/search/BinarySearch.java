package lib.algo.search;

/**
 * @author Manish Singh
 */
public class BinarySearch {
    static <T extends Comparable<T>> int upperBound(T a[], int n, T x) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x.compareTo(a[mid]) >= 0) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    static <T extends Comparable<T>> int lowerBound(T a[], int n, T x) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x.compareTo(a[mid]) <= 0) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static int upperBound(int a[], int n, int x) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x >= a[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    static int lowerBound(int a[], int n, int x) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x <= a[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
