package lib.algo.search;

/**
 * @author Manish Singh
 */
public class BinarySearch {
    public static <T extends Comparable<T>> int upperBound(T arr[], T x) {
        int l = 0;
        int h = arr.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x.compareTo(arr[mid]) >= 0) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    public static <T extends Comparable<T>> int lowerBound(T arr[], T x) {
        int l = 0;
        int h = arr.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x.compareTo(arr[mid]) <= 0) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int upperBound(int arr[], int x) {
        int l = 0;
        int h = arr.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x >= arr[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    public static int lowerBound(int arr[], int x) {
        int l = 0;
        int h = arr.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (x <= arr[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
